import com.my.command.filter.LogoutFilterCommand;
import com.my.model.Employee;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class LogoutFilterCommandTest {
    @Test
    void deniedAccess() throws IOException, ServletException {
        final LogoutFilterCommand logoutFilterCommand = new LogoutFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        when(session.getAttribute("user")).thenReturn(null);
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        final String loginPath = request.getContextPath() + "/controller?command=LOGIN_PAGE";

        logoutFilterCommand.getAccess(request,response);
        verify(response,times(1)).sendRedirect(loginPath);
    }
    @Test
    void giveAccess() throws IOException, ServletException {
        final LogoutFilterCommand logoutFilterCommand = new LogoutFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        when(session.getAttribute("user")).thenReturn(new Employee());
        logoutFilterCommand.getAccess(request,response);
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        verify(response,never()).sendRedirect(profilePath);
    }
}