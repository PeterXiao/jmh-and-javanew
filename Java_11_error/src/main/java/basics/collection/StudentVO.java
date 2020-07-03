/**
 *
 */
package basics.collection;

/**
 * @author Office
 *
 */
public class StudentVO {

    public int getNum() {
	return Num;
    }

    public void setNum(int num) {
	Num = num;
    }

    public String getNameString() {
	return nameString;
    }

    public void setNameString(String nameString) {
	this.nameString = nameString;
    }

    public int getCode() {
	return code;
    }

    public void setCode(int code) {
	this.code = code;
    }
    int Num;
    String nameString;
    int code;
    public StudentVO(int i, String string, int i2) {
	// TODO Auto-generated constructor stub
	Num = i;
	nameString = string;
	code = i2;
    }

}
