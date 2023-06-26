package course;

/*
 * Title : InfoCourse.java
 * Purpose : All information regarding courses
 * Created by: Shivanshu Nigam
 */

public class InfoCourse {

	private String courcecode;
	private int semoryear;
	private boolean isdeclared;
	private String courcename;
	public void setCourceName(String courcename)
	{
		this.courcename=courcename;
	}
	public void setCourceCode(String courcecode)
	{
		this.courcecode=courcecode;
	}
	public void setSemorYear(int semoryear)
	{
		this.semoryear=semoryear;
	}
	public void setIsDeclared(boolean isdeclared)
	{
		this.isdeclared=isdeclared;
	}
	public String getCourceName()
	{
		return courcename!=null?courcename:new DataCourse().getcourcename(courcecode);
	}
	public String getCourceCode()
	{
		return courcecode;
	}
	public int getSemorYear()
	{
		return semoryear;
	}
	public boolean getIsDeclared()
	{
		return isdeclared;
	}
}