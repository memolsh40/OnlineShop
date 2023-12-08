package memol.shop.app.config.filters;

import memol.shop.app.config.JwtTokenUtil;
import memol.shop.app.helper.exeptions.JwtTokenExeption;
import memol.shop.app.helper.ui.uimodels.UserVM;
import memol.shop.app.services.people.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtRequestFilter implements Filter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;
    private List<String> excludeUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      excludeUrls=new ArrayList<>();
      excludeUrls.add("/api/user/login");
      excludeUrls.add("/api/color/");
      excludeUrls.add("/api/utils/upload/files/");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    try {

        String url =((HttpServletRequest)servletRequest).getRequestURI().toLowerCase();
        if (excludeUrls.stream().anyMatch(x-> url.startsWith(x))){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

    String requestTokenHeader=((HttpServletRequest)servletRequest).getHeader("Authorization");
    if (requestTokenHeader==null||!requestTokenHeader.startsWith("Bearer "))
        throw new JwtTokenExeption("request token header does not set");

    String token = requestTokenHeader.substring(7);
    String username= jwtTokenUtil.getUsernameFromToken(token);

    if (username==null)
        throw new JwtTokenExeption("username can not resolve");

        UserVM userVM=new UserVM(userService.getByUsername(username));
if (!jwtTokenUtil.validateToken(token,userVM))
    throw new JwtTokenExeption("invalid token");

filterChain.doFilter(servletRequest,servletResponse);

    } catch (JwtTokenExeption ex){
        ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorization");
    }

    catch (Exception ex){
        ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,ex.getMessage());
}
    }
}
