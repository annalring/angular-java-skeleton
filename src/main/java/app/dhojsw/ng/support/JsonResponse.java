package app.dhojsw.ng.support;

public class JsonResponse {
	public Object json;
	public double responseTime;
	public double requestTime;

	public JsonResponse(double requestTime, Object json) {
		this.requestTime = requestTime;
		this.json = json;
		this.responseTime = System.currentTimeMillis();
	}

	public double getTimeCost() {
		return this.responseTime - this.requestTime;
	}

}
