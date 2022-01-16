package worksheet_7;

public class CompareEdge implements java.util.Comparator {
	public int compare(Object a, Object b) {
		if (((Edge) a).w < ((Edge) b).w)
			return (-1);
		if (((Edge) a).w > ((Edge) b).w)
			return (1);
		return (0);
	}
}
