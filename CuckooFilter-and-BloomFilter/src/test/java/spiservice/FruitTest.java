/**
 * 
 */
package spiservice;

import static org.junit.Assert.*;

import org.junit.Test;



/**
 * @author xiaoy
 *
 */
public class FruitTest {

	/**
	 * Test method for {@link spiservice.Fruit#getName()}.
	 */
	@Test
	public final void testGetName() {
		fail("Not yet implemented"); // TODO
		
		// assertTrue("implemented");
	}
	/*public static String getData(String key) throws InterruptedException {
		//从Redis查询数据
		
		String result = getDataByKV(key);
		//参数校验
		if (StringUtils.isBlank(result)) {
			try {
				//获得锁
				if (reenLock.tryLock()) {
					//去数据库查询
					result = getDataByDB(key);
					//校验
					if (StringUtils.isNotBlank(result)) {
						//插进缓存
						setDataToKV(key, result);
					}
				} else {
					//睡一会再拿
					Thread.sleep(100L);
					result = getData(key);
				}
			} finally {
				//释放锁
				reenLock.unlock();
			}
		}
		return result;
	}*/

	public static void main(String[] args) {
	    //创建一个原始的二维数组
	    //0：没有棋子，1：黑子，2：白子
	    int chessArr1[][] = new int[11][11];
	    //下面先固定二维数组的元素，后面可优化~
	    chessArr1[1][2] = 1;
	    chessArr1[2][3] = 2;
	    chessArr1[4][5] = 2;
	    //输出原始的二维数组：
	    System.out.println("原始的二维数组：");
	    printArray(chessArr1);

	    //下面将二维数组转化为稀疏数组
	    //1.先遍历二维数组，得到非0数据的个数
	    int sum = 0;

	    for (int i = 0; i < 11; i++) {
	        for (int j = 0; j < 11; j++) {
	            if (chessArr1[i][j] != 0) {
	                sum++;
	            }
	        }
	    }

	    //2.创建对应的稀疏数组
	    int sparesArr[][] = new int[sum + 1][3];
	    //给稀疏数组赋值
	    sparesArr[0][0] = 11;
	    sparesArr[0][1] = 11;
	    sparesArr[0][2] = sum;

	    //遍历二维数组，将非0的值存放在sparesArr中
	    int count = 0;//count 用于记录是第几个非0数据
	    for (int i = 0; i < 11; i++) {
	        for (int j = 0; j < 11; j++) {
	            if (chessArr1[i][j] != 0) {
	                count++;
	                sparesArr[count][0] = i;
	                sparesArr[count][1] = j;
	                sparesArr[count][2] = chessArr1[i][j];
	            }
	        }
	    }

	    //输出稀疏数组的形式
	    System.out.println();
	    System.out.println("得到的稀疏数组为：");
	    printArray(sparesArr);
	    System.out.println();

	    //下面将稀疏数组恢复成二维数组
	    //先读取稀疏数组的第一行元素，根据其数据，创建原始的二维数组
	    int chessArr2[][] = new int[sparesArr[0][0]][sparesArr[0][1]];


	    //读取稀疏数组后几行的元素（从第二行开始），并赋值给原始的二维数组即可

	    for (int i = 1; i < sparesArr.length; i++) {
	        chessArr2[sparesArr[i][0]][sparesArr[i][1]] = sparesArr[i][2];
	    }

	    //输出恢复后的二维数组
	    System.out.println();
	    System.out.println("恢复后的二维数组");
	    printArray(chessArr2);
	}

	//打印数组
	public static void printArray(int[][] array) {
	    for (int i = 0; i < array.length; i++) {
	        for (int j = 0; j < array[0].length; j++) {
	            System.out.printf("%d\t", array[i][j]);
	        }
	        System.out.println();
	    }
	}

}
