package GraphAStar;
import java.util.*;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;

public class AlgoritmnAStar {
	
	public static <T,E> void AStar(Graph<T,E> graph , T start , T destiny)
	{
		BeamSearch(graph , start , destiny , 0);
	}
	
	public static <T,E> void BeamSearch(Graph<T,E> graph , T start , T destiny , int maxStack) 
	{
		List<SearchAStar<T>> open = new ArrayList<SearchAStar<T>>();
		List<T> closed = new ArrayList<T>();

		open.add( new SearchAStar<T>( start , 0 ));
		
		boolean finded = false;
		
		while(open.size() != 0 && !finded) 
		{
			SearchAStar<T>current = open.get(0);
			open.remove(0);
			closed.add( current.getValue() ); 
			if(current.getValue().equals(destiny)) 
			{
				finded = true;
			}
			else
			{
				List<SearchAStar<T>> adjacents = AllAdjacentNotRepeted(graph , current , closed);
				InsertAdjacent(open , adjacents ,maxStack);
			}
		}
	}
	
	public static <T,E> List<SearchAStar<T>> AllAdjacentNotRepeted(Graph<T,E> graph , SearchAStar<T> source , List<T> visited)
	{
		List<SearchAStar<T>> ret= new ArrayList<SearchAStar<T>>();
		List<T>adjacents = Graphs.neighborListOf(graph, source.getValue());
		
		for(int i = 0 ; i < adjacents.size() ; i++)
		{
			if( !visited.contains(adjacents.get(i) ) ) 
			{
				Set<E> edgeDest = graph.getAllEdges(source.getValue(), adjacents.get(i));
				if( edgeDest.size() != 0) {
					E edge = graph.getEdge(source.getValue(), adjacents.get(i));
					double cost = graph.getEdgeWeight(edge);
					ret.add( new SearchAStar<T> (adjacents.get(i) , source.getCost() + cost)  );
				}
			}
			
		}
		
		return ret;
	}
	
	public static <T> void InsertAdjacent(List<SearchAStar<T>> open , List<SearchAStar<T>> adjacents ,int maxStack)
	{
		
		int encounter = -1;
		
		int i= 0;
		while( i < adjacents.size())
		{
			if(maxStack == 0 || open.size() <= maxStack ) {
				boolean finded = false;
				boolean remove = false;
				int insertOn = -1;
				int j=0;
				
				
				while( j < open.size() && !finded)
				{
					if(open.get(j).getValue() == adjacents.get(i).getValue())
					{
						finded = true;
						encounter = j;
						if( open.get(j).getCost() >= adjacents.get(i).getCost() )
						{
							remove = true;
						}
					}
					if( ( (int)open.get(j).getValue() - open.get(j).getCost() ) <= ( (int)adjacents.get(i).getValue() - adjacents.get(i).getCost()) && insertOn == -1 )
					{
						insertOn = j;
					}
					j++;
				}
				if(finded && remove)
				{
					open.remove(encounter);
				}
				if(insertOn != -1)
				{
					open.add(insertOn, adjacents.get(i));
				}
				else
				{
					if(open.size() != 0) {
						open.add( open.size() , adjacents.get(i));	
					}
					else
					{
						open.add( adjacents.get(i));
						
					}
				}
			}
			i++;
		}
	}

}
