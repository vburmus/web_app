import com.my.command.filter.LoginFilterCommand;
import com.my.model.Employee;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

class LoginFilterCommandTest {

    @Test
    void giveAccess() throws IOException, ServletException {
        final LoginFilterCommand loginFilterCommand = new LoginFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        when(session.getAttribute("user")).thenReturn(null);
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        loginFilterCommand.getAccess(request,response);
        verify(response,never()).sendRedirect(profilePath);
    }
    @Test
    void deniedAccess() throws IOException, ServletException {
        final LoginFilterCommand loginFilterCommand = new LoginFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        when(session.getAttribute("user")).thenReturn(new Employee());
        loginFilterCommand.getAccess(request,response);
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        verify(response,times(1)).sendRedirect(profilePath);
    }
}