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

	// �߳���С����һ����
	private int min;

	/**
	 * 
	 * ���� ��Žڵ�����ݽṹ
	 * 
	 */
	class Node {
		int x;
		int y;
	}

	// �������������εı߳�
	private int maxLength() {
		// �Ա߳�С��Ϊ׼
		min = n > m ? m : n;
		// ��2����Ԫ��ʼ���㣬ֱ��n����Ԫ��������
		int max = 1;
		for (int n = 2; n <= min; n++) {
			// �������еĵ�Ԫ������������򷵻ؽ���n+1����Ԫ��ı���
			int value = traverse(n);
			// ���ص��п�����n-1����û�б�n�����������
			if (value < n) {
				return value;
			}

			max = value > max ? value : max;
		}

		return max;

	}

	// ��nΪ��׼����,
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
				// ��������Ľڵ��ܹ��ҵ�n�ߵ������Σ��򷵻أ�������Ч��ѭ��
				if (temp == num * num) {
					return num;
				}
			}
		}

		// �������еĽڵ�û��n�ߵ������Σ�˵��ֻ��n-1�ߵ������δ���
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
