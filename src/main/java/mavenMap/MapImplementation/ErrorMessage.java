package mavenMap.MapImplementation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessage;
	@Override
	public String toString() {
		return "ErrorMessage [errorMessage=" + errorMessage + "]";
	}

	
	public ErrorMessage(String message)
	{
		this.errorMessage = message;
	}
	
	public String getMessage() {
		return errorMessage;
	}


}
