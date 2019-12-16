package xupt.se.ttms.domain;

public class backMessage {
	private int style;
	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	Data data = null;

	public backMessage(int style, String msg, Object data) {
		super();
		this.style = style;
		this.data = new Data(msg, data);
	}

}

class Data {
	private String msg;
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	private Object obj;

	public Data(String msg, Object obj) {
		super();
		this.msg = msg;
		this.obj = obj;
	}
}