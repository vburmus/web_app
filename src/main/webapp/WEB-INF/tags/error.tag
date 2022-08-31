<%@ tag %>
<%@ attribute name="message" required="true" type="java.lang.String"  %>
<%
  if(message!=null){
      out.print("<p class=\"text-danger \" >" + message + "</p>");
    }
%>