import java.util.Scanner;

/**
 * 
 * @author Vinicius Galdino
 * @version 1.0
 *
 */
//CALCULAR A DETERMINANTE DE QUALQUER TAMANHO 
public class DeterminanteMatriz {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		int x = 0, y = 0, DP = 0, DS = 0, determinante = 0;
		
		// INSERIR O TAMANHO DA MATRIZ
		do {
		System.out.print("Informe um número positivo para o tamanho da matriz: ");
		x = entrada.nextInt();
		}while(x<=0);
		
		// VALOR DO TAMANHO INSERIDO NA MATRIZ
		int[][] matriz = new int[x][x];
		
		System.out.println("");
		System.out.println("---------- Matriz de Ordem "+x+" -----------");		
		// INSERIR OS VALORES DA MATRIZ
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print("Digite a matriz ["+(i+1)+","+(j+1)+"]= ");
				matriz[i][j] = entrada.nextInt();
			}
		}
		
		System.out.println("");
		
		if(x==0) {
			determinante = 1;
		}else if(x==1) {
			determinante = matriz[0][0];
		}else if(x==2) {
			// MATRIZ QUADRADAS
			DP = matriz[0][0]*matriz[1][1];
			System.out.println("DP: "+DP);
			DS = matriz[0][1]*matriz[1][0];
			System.out.println("DS: "+(DS));
			determinante = DP-DS;
		}else {
			// ENCONTRAR A DIAGONAL SECUNDARIO
			for(int i = (x-1); i >= 0; i--) {
				// VARIAVEL Y PARA SUBSTITUI O VALOR DE J, ALTERNANDO SEU VALOR
				y = i;
				for (int j = 0; j < x; j++) {
					if(y<0) {
						y = (x - 1);
					}
					System.out.print("["+(j+1)+","+(1+y)+"]= "+matriz[j][y] +"\t");
					// RESETA E ATRIBUI A DS
					if(j==0) {
						DS = matriz[j][y];
					}else {
						DS *= matriz[j][y];
					}
					y--;
							
				}				
				System.out.println("DS: "+(-DS));
				System.out.println("");
				determinante += -(DS);
			}
			
			
			System.out.println();
			
			// ENCONTRAR DIAGONAL PRINCIPAL
			for (int i = 0; i < x; i++) {
				// VARIAVEL Y PARA SUBSTITUI O VALOR DE J, ALTERNANDO SEU VALOR
				y = i;
				for (int j = 0; j < x; j++) {
					if(y >= x) {
						y = 0;
					}
					System.out.print("["+(j+1)+","+(y+1)+"]= "+matriz[j][y]+"\t");
					//RESETA E ATRIBUI A DP
					if(j==0) {
						DP = matriz[j][y];
					}else {
						DP *= matriz[j][y];
					}
					y++;
					
					
				}
				System.out.println("DP: "+DP);
				System.out.println("");
				determinante += DP;		
			}
		
		}
		
		System.out.println();
		
		// INFORMAR A DETERMINANTE DA MATRIZ
		System.out.println("Determinante é, D = "+determinante);
		
		entrada.close();
	}

}
