import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Administrator
 * 
 */
public class TestDemo {
	private int[][] value = null;

	private int n;
	private int m;

	// 边长较小的那一个边
	private int min;

	/**
	 * 
	 * 定义 存放节点的数据结构
	 * 
	 */
	class Node {
		int x;
		int y;
	}

	// 计算最大的正方形的边长
	private int maxLength() {
		// 以边长小的为准
		min = n > m ? m : n;
		// 从2个单元格开始计算，直到n个单元格计算结束
		int max = 1;
		for (int n = 2; n <= min; n++) {
			// 遍历所有的单元格，如果遍历到则返回进行n+1个单元格的遍历
			int value = traverse(n);
			// 返回的有可能是n-1代表没有比n更大的正方形
			if (value < n) {
				return value;
			}

			max = value > max ? value : max;
		}

		return max;

	}

	// 以n为基准遍历,
	private int traverse(int num) {
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				int temp = 0;
				for (Node node : calcualte(num)) {
					if (node.x + i < m && node.y + j < this.n) {
						if (value[node.x + i][node.y + j] == 1) {
							temp++;
							continue;
						} else {
							break;
						}
					}
				}
				// 如果遍历的节点能够找到n边的正方形，则返回，避免无效的循环
				if (temp == num * num) {
					return num;
				}
			}
		}

		// 遍历所有的节点没有n边的正方形，说明只有n-1边的正方形存在
		return num - 1;
	}

	private List<Node> calcualte(int n) {
		List<Node> nodes = new ArrayList<Node>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Node node = new Node();
				node.x = i;
				node.y = j;
				nodes.add(node);
			}
		}
		return nodes;
	}

	public static void main(String[] args) {

		int a[][] = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 1, 1, 1, 0, 1 },
				{ 1, 1, 1, 1, 1 } };

		TestDemo testDemo = new TestDemo();
		testDemo.m = 4;
		testDemo.n = 5;
		testDemo.value = a;
		System.out.println("The max Length is " + testDemo.maxLength());

	}
}
