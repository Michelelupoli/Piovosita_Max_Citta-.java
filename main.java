//Inserite le piovosità medie mensili di 10 città, ricercare una città e calcolarne la sua piovosità massima
import java.io.*;
public class PiovositàCittà {
	public static void main (String args[])
	{
		//Impostazione standard input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		
		//Dichiarazione variabili
		final int NCITTA = 10, NMESI = 12;
		String citta[] = new String[NCITTA];
		String mesi[] = new String[NMESI];
		double piovosita[][] = new double[NCITTA][NMESI];
		String ricerca = null;
		int flag = 0;
		double max = 0;
		String mese = null;
		
		//Inserimento città in un vettore
		System.out.println("Stai inserendo i nomi delle città.");
		for (int i=0; i<NCITTA; i++)
		{
			System.out.print("Inserisci città n. "+i+": ");
			try
			{
				citta[i] = tastiera.readLine();
			}
			catch (Exception e)
			{
				System.out.println("Il valore inserito non è valido! ");
				i--;
			}
		}
		
		//Inserimento mesi in un vettore
		System.out.println("Stai inserendo i nomi dei mesi.");
		for (int i=0; i<NMESI; i++)
		{
			System.out.print("Inserisci mese n. "+i+": ");
			try 
			{
				mesi[i] = tastiera.readLine();
			}
			catch (Exception e)
			{
				System.out.println("Il valore inserito non è corretto!");
				i--;
			}
		}
		
		//Inserimento piovosità medie per città
		System.out.println("Stai inserendo le piovosità medie per città.");
		for (int i=0; i<NCITTA; i++)
		{
			System.out.println("Inserimento piovosità nella città di "+"'"+citta[i]+"'"+".");
			for (int j=0; j<NMESI; j++)
			{
				System.out.print("Inserisci piovosità nel mese di "+"'"+mesi[j]+"'"+": ");
				try
				{
					String numeroLetto = tastiera.readLine();
					piovosita[i][j] = Integer.valueOf(numeroLetto).intValue();
				}
				catch (Exception e)
				{
					System.out.println("Il valore inserito non è valido!");
					i--;
				}
			}
		}
		
		//Inserimento e ricerca di una città
		do {
			System.out.print("Inserisci il nome della città della quale si vuole conoscere la piovosità massima: ");
			try
			{
				ricerca = tastiera.readLine();
			}
			catch (Exception e)
			{
				System.out.println("Il valore inserito non è valido!");
			}
			for (int i=0; i<NCITTA; i++)
			{
				for (int j=0; j<NMESI; j++)
				{
					if (ricerca.equals(citta[i]))
					{
						if (piovosita[i][j]>max)
						{
							max = piovosita[i][j];		
							flag = 1; mese = mesi[j];
						}
					}
				}
			}
		if (flag == 0)
		{
			System.out.println("La città inserita non è stata trovata! Riprova!");
		}
		}
		while (flag == 0);
		
		//Stampa pivosità massima con relativo mese e città
		for (int i=0; i<NCITTA; i++)
		{
			for (int j=0; j<NMESI; j++)
			{
				System.out.println("Città: "+ricerca+".   Piovosità massima: "+max+"%."+"   Mese piovosità: "+mese+".");
				j = NMESI; i = NCITTA;
			}
		}
		return;
	}
}
