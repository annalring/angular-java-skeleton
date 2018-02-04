package app.dhojsw.ng.command;

public class CommandResponse {
	    public String command;
	    public Object json;
	    public double responseTime;
	    public double requestTime;
	    public CommandResponse(double requestTime, String command,Object json ) {
	        this.requestTime = requestTime;
	        this.json = json;
	        this.command = command;
	        this.responseTime = System.currentTimeMillis();
	    }

	    public double getTimeCost() {
	        return this.responseTime - this.requestTime;
	    }
	
}
