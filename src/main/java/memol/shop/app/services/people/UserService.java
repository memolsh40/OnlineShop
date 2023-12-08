package memol.shop.app.services.people;

import memol.shop.app.entities.people.User;
import memol.shop.app.helper.exeptions.DataNotFoundExeption;
import memol.shop.app.helper.utils.SecurityUtils;
import memol.shop.app.repositories.people.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private SecurityUtils securityUtils;


    public User auth (String username,String password){
        try {
            password=securityUtils.encryptSHA1(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return repository.findFirstByUsernameAndPassword(username, password);
    }
    public List<User> getAll(Integer pageSize, Integer pageNumber){
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("id"));
        Page<User> all=repository.findAll(page);
        return all.toList();
    }
    public long getAllCount(){
        return repository.count();
    }
    public User getByUsername (String username){
        //TODO: hash password
        return repository.findFirstByUsername(username);
    }

    public User getByID(long id){
       Optional<User> data= repository.findById(id);
        if (data.isPresent()) return data.get();
        return null;
    }

    public User add(User data) throws Exception {
        if(data.getusername() == null || data.getusername().equals(""))
            throw new Exception("Please enter username");
        User oldUser = getByUsername(data.getusername());
        if (oldUser != null)
            throw new Exception("Duplicated username. please change your username.");
        //TODO: ex: check password strength
        if(data.getPassword() == null || data.getPassword().equals(""))
            throw new Exception("Please enter password");
        data.setPassword(securityUtils.encryptSHA1(data.getPassword()));
        return repository.save(data);
    }
    public User update(User data) throws DataNotFoundExeption, NoSuchAlgorithmException {
        User oldData = getByID(data.getId());
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+data.getId()+" not found");
        }
        oldData.setEmail(data.getEmail());
        oldData.setEnable(data.isEnable());
        oldData.setFirstName(data.getFirstName());
        oldData.setLastName(data.getLastName());
        if (data.getPassword()!=null    &&  !data.getPassword().equals("")){
            oldData.setPassword(securityUtils.encryptSHA1(data.getPassword()));
        }
        return repository.save(oldData);
    }

    public boolean deleteById(long id) throws DataNotFoundExeption {
        User oldData = getByID(id);
        if (oldData==null){
            throw new DataNotFoundExeption("data with id "+id+" not found");
        }
        repository.deleteById(id);
        return true;
    }
    public User changePassword(long id,String oldPassword,String newPassword) throws DataNotFoundExeption {
        try {
            oldPassword=securityUtils.encryptSHA1(oldPassword);
            newPassword=securityUtils.encryptSHA1(newPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        User user=getByID(id);
        if (user == null)
            throw new DataNotFoundExeption("User not found");
        if (!user.getPassword().equals(oldPassword))
            throw new DataNotFoundExeption("invalid old password");
        user.setPassword(newPassword);
        return repository.save(user);

    }
}
