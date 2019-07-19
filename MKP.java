import java.util.Scanner;
public class MKP {
			private static int n, m;// n物品个数,m限制条件个数
			private static double[] v; // 定义了一个一维数组v,用来存放价值
			private static double[][] w; // 定义了一个二维数组w,用来存放约束条件
			private static double[] a; // 定义了一个一维数组a,用来存放限制条件
			private static double cv;// 当前的价值
			private static double bestv;// 目前最优的价值
			private static double r;// 剩余物品的价值
			private static int[] cx;// 存放当前解
			private static int[] bestx;// 存放最终解

public static double YS(double[][] w, double[] v, double[] a)
			
{
				bestv = 0; //初始化,即目前最优的价值
				cx = new int[n];
				bestx = new int[n]; // 初始化r，即剩余最大价格
				for (int i = 0; i < n; i++)
				{
					r += v[i]; //r=r+v[i]
				}
				// 调用回溯法计算
				BackTrack(0,cv);
				return bestv; //返回当前最优解
			}

			public static void BackTrack(int i, double cv)
			{
				if (i == n)
				{// 到达叶结点
					if (cv > bestv) //如果当前价值大于当前最优的价值
					{
						for (int y = 0; y <n; y++)
						{
							bestx[y] = cx[y]; //当前最优的价值等于当前解
						}

						bestv = cv; //当前最优的价值等于当前价值
						System.out.println(bestv); //输出当前最优的价值
					}
					return; //返回
				}
				r -= v[i]; //r=r-v[i]
				cx[i]=1; //当前解等于1
						for(int j=0;j<m;j++)
							{
							if (a[j]-w[j][i]<0) //如果限制条件减去约束条件的值小于0
							{// 搜索左子树
								
								cx[i] = 0; //当前解等于0
								break; //跳出循环
							}}
						if(cx[i]==1) //如果当前解等于1
								{cv += v[i]; //当前价值等于当前价值加上价值
								for(int s=0;s<m;s++)
									{a[s]-=w[s][i]; //限制条件等于限制条件减约束条件
									}
								BackTrack(i + 1,cv); //回溯
								cv -= v[i]; //当前价值等于当前价值减价值
								for(int p=0;p<m;p++)
								{a[p]+=w[p][i];}// 恢复现场
								// 恢复现场
								}
				
					if (cv + r > bestv) //如果当前价值与剩余价值之和大于当前最优的价值
					{// 剪枝操作
						cx[i] = 0;// 搜索右子树
						BackTrack(i + 1,cv); //回溯
					}
					r += v[i];
				} // 恢复现场
			

public static void main(String[] args)
			{

				Scanner input = new Scanner(System.in);
				try {
				n = input.nextInt(); //输入物品个数n的值
				m = input.nextInt(); //输入限制条件m的值
				v = new double[n]; //开辟了行为n的双精度型一维数组v
				w = new double[m][n]; //开辟了行为m,列为n的双精度型二维数组w
				a = new double[m]; //开辟了行为m的双精度型一维数组a
				System.out.println("请输入n个物品的价值:");
				for (int i = 0; i < n; i++)
				{
					v[i] = input.nextDouble(); //输入价值数组的值
				}
				System.out.println("请输入约束条件:");
				for (int i = 0; i < m; i++)
				{
					for (int j = 0; j < n; j++)
						w[i][j] = input.nextInt(); //输入约束条件数组的值

				}
				System.out.println("请输入m个属性限制条件:");
				for (int j = 0; j < m; j++)
				{
					a[j] = input.nextInt(); //输入限制条件数组的值
				}
				YS(w, v, a); //调用YS(w,v,a)方法
				System.out.println("最大价值为：" + bestv); //输出最大值
			}finally {
				input.close();
			}
		}

		}