import com.my.command.filter.RegisterFilterCommand;
import com.my.model.Employee;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

class RegisterFilterCommandTest {
    @Test
    void deniedAccess() throws IOException, ServletException {
        final RegisterFilterCommand registerFilterCommand = new RegisterFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";

        when(session.getAttribute("user")).thenReturn(new Employee());
        registerFilterCommand.getAccess(request, response);
        verify(response, times(1)).sendRedirect(profilePath);

    }
    @Test
    void openedAccess() throws IOException, ServletException {
        final RegisterFilterCommand registerFilterCommand = new RegisterFilterCommand();
        final HttpSession session = mock(HttpSession.class);
        final HttpServletRequest request = mock(HttpServletRequest.class);
        final HttpServletResponse response = mock(HttpServletResponse.class);
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/cashregister");
        when(session.getAttribute("user")).thenReturn(null);
        registerFilterCommand.getAccess(request,response);
         final String profilePath = request.getContextPath() + "/controller?command=PROFILE_PAGE";
        verify(response,never()).sendRedirect(profilePath);
    }

}