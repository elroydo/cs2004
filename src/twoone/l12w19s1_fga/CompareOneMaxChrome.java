package twoone.l12w19s1_fga;

//Compare OneMax Chromosomes - used to sort an ArrayList of ScalesChrome
public class CompareOneMaxChrome implements java.util.Comparator<OneMaxChrome> {
	public int compare(OneMaxChrome a, OneMaxChrome b)  {
		if (a.GetFitness() < b.GetFitness()) return(1);
		if (a.GetFitness() > b.GetFitness()) return(-1);
		return(0);
	}
}