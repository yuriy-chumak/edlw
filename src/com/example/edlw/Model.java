package com.example.edlw;

// https://www.dropbox.com/s/co0ppbbh9k9y5ms/%D1%8D%D0%BB%D0%B5%D0%BA%D1%82%D1%80%D0%BE%D0%BD%D0%BD%D1%8B%D0%B9%20%D0%B6%D1%83%D1%80%D0%BD%D0%B0%D0%BB%20%D1%80%D0%B0%D0%B1%D0%BE%D1%82%D1%8B%20%D0%B7%D0%B2%D0%B5%D0%BD%D1%8C%D0%B5%D0%B2.xls
// вот табличка, пароль к ней 280580, столбец 1 необязателен для ввода, второй обязателен, третий снова необязателен
public class Model {
	public static void setA1(long x) { }
	
	// Данные
	public static int A5 = 0;	// minutes!
	
	public static int B5 = 0; public static void setB5(int x) { B5 = x; calc(); }
	public static int B6 = 0; public static void setB6(int x) { B6 = x; calc(); }
	public static int B7 = 0; public static void setB7(int x) { B7 = x; calc(); }
	public static int B8 = 0; public static void setB8(int x) { B8 = x; calc(); }
	public static int B9 = 0; public static void setB9(int x) { B9 = x; calc(); }
	
	public static int C5 = 0; public static void setC5(int x) { C5 = x; calc(); }
	public static int C6 = 0; public static void setC6(int x) { C6 = x; calc(); }
	public static int C7 = 0; public static void setC7(int x) { C7 = x; calc(); }
	public static int C8 = 0; public static void setC8(int x) { C8 = x; calc(); }
	public static int C9 = 0; public static void setC9(int x) { C9 = x; calc(); }
	
	// Результаты
	public static int D5 = 0;
	public static int D6 = 0;
	public static int D7 = 0;
	public static int D8 = 0;
	public static int D9 = 0;

	public static int E5 = 0;
	public static int F5 = 0;
	
	public static int G5 = 0;
	public static int H5 = 0;
	public static int I5 = 0;
	public static int J5 = 0;
	public static int K5 = 0;
	public static int L5 = 0;
	public static int M5 = 0;
	
	public static int G8 = 0;
	public static int H8 = 0;
	public static int I8 = 0;
	public static int J8 = 0;
	public static int K8 = 0;
	public static int L8 = 0;
	public static int M8 = 0;
	
	
	//
	public static void calc()
	{
		// Затрачено на путь к месту работы
		D5 = B5 - C5;
		D6 = B6 - C6;
		D7 = B7 - C7;
		D8 = B8 - C8;
		D9 = B9 - C9;
		
		//   общие
		// Т общ. =(MIN(B5:B9)-10)*7/44
		E5 = (MIN(B5, B6, B7, B8, B9) - 10) * 7/44;
		
		// предполагае-мое время возвращения =A5+TIME(0;E5;0)
		F5 = A5 + E5;
		
		//   очаг найден
		// Рк. вых. =MAX(D5:D9)*1.5+10 & =MAX(D5:D9)*2+10
		G5 = (MAX(D5, D6, D7, D8, D9) * 3 /2) + 10;
		G8 = (MAX(D5, D6, D7, D8, D9) * 2   ) + 10;
		// Траб. у очага =(MIN(C5:C9)-G5)*7/44 & =(MIN(C5:C9)-G8)*7/44
		H5 = (MIN(C5, C6, C7, C8, C9) - G5) * 7/44;
		H8 = (MIN(C5, C6, C7, C8, C9) - G8) * 7/44;
		// Tдо подачи команды на возвращение =(MIN(B5:B9)-G5)*7/44 & =(MIN(B5:B9)-G8)*7/44
		I5 = (MIN(B5, B6, B7, B8, B9) - G5) * 7/44;
		I8 = (MIN(B5, B6, B7, B8, B9) - G8) * 7/44;
		// Tподачи команды на возвращение =A5+TIME(0;I5;0) & =A5+TIME(0;I8;0)
		J5 = A5 + I5;
		J8 = A5 + I8;
		
		//   очаг не найден
		// Pmax. пад. =(MIN(B5:B9)-10)/2.5 & =(MIN(B5:B9)-10)/3
		K5 = (MIN(B5, B6, B7, B8, B9) - 10) * 2 /5;
		K8 = (MIN(B5, B6, B7, B8, B9) - 10)     /3;
		// Pк. вых. =(MIN(B5:B9)-K5) & =(MIN(B5:B9)-K8)
		L5 = (MIN(B5, B6, B7, B8, B9) - K5);
		L8 = (MIN(B5, B6, B7, B8, B9) - K8);
		// ΔТ =(K5*7)/44 & =(K8*7)/44
		M5 = (K5 * 70)/44;		// (результат разделить на 10!)
		M8 = (K8 * 70)/44;		// (результат разделить на 10!)
	}
	
	
	private static final int MIN(int a, int b, int c, int d, int e)
	{
		return min(a, min(b, min(c, min(d, e))));
	}
	private static final int min(int a, int b)
	{
		if (a == 0)
			return b;
		if (b == 0)
			return a;
		return a < b ? a : b;
	}
	private static final int MAX(int a, int b, int c, int d, int e)
	{
		return max(a, max(b, max(c, max(d, e))));
	}
	private static final int max(int a, int b)
	{
		return a > b ? a : b;
	}
}