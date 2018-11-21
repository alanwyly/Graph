package GraphAStar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class Main {

	public static Graph<Integer, DefaultWeightedEdge> GenerateRandomGraph(List<Integer> vertexes )
	{
		Graph<Integer, DefaultWeightedEdge> grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
		//RANDOM DE MAXIMOS VERTICES , VA DE MAXIMO 100 A 200
		int maxVertexes = ThreadLocalRandom.current().nextInt(100,  200);
		
		for(int i = 0 ; i <= maxVertexes ; i++)
		{
			int random = ThreadLocalRandom.current().nextInt(0,  1000);
			if( !vertexes.contains(random))
			{
				Integer value = new Integer(random);
				vertexes.add(value);
				grafo.addVertex(value);
			}
		}
		//EN ESTA PARTE AGREGO UN CAMINO QUE LLEVE A TODO , YO QUERIA SER UN MAESTRO POKEMON , NO PUDE SERLO , POR ESO HICE ESTA BOSTA :D
		List<Integer> open = new ArrayList<Integer>(vertexes);
		
		int current = 0;
		int next = 0;
		while( open.size() != 2 )
		{
			boolean repeat = true;
			
			while(repeat) {
				next = ThreadLocalRandom.current().nextInt(0,  open.size()-1);
				repeat = current == next;
			}
			
			DefaultWeightedEdge edge = new DefaultWeightedEdge();

	        grafo.addEdge( open.get(current) , open.get(next) , edge);
	        
	        int cost = ThreadLocalRandom.current().nextInt(0, 1000);
	        
	        grafo.setEdgeWeight(edge, cost);
	        
	        open.remove(current);
	        if(current < next) {
	        	current = next == 0 ? 0 : next-1;
	        }
	        else
	        {
	        	current = next;
	        }
			
		}
		//ACA ESTA LAS ARISTAS EXTRA A AGREGAR , ES UN RANDOM DEL 200 AL 300
		int addingEdges = ThreadLocalRandom.current().nextInt(200,  300);
		
		for(int i = 0 ; i <= addingEdges ; i++ )
		{
			int source = ThreadLocalRandom.current().nextInt(0,  vertexes.size()-1);
			int destiny = 0;
			boolean repeat = true;
			
			while(repeat) 
			{
				destiny = ThreadLocalRandom.current().nextInt(0,  vertexes.size()-1);
				repeat = source == destiny;
			}
			
			DefaultWeightedEdge edge = new DefaultWeightedEdge();
			
			grafo.addEdge( vertexes.get(source) , vertexes.get(destiny) , edge);
		}
		
		return grafo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 10 ; i++) {
			List<Integer> vertexes = new ArrayList<Integer>();
			Graph<Integer, DefaultWeightedEdge> grafo = GenerateRandomGraph(vertexes);
			
			int source =  ThreadLocalRandom.current().nextInt(0,  vertexes.size()-1) ;
			int destiny=0;
			
			boolean repeat = true;
			
			while(repeat) {
				destiny = ThreadLocalRandom.current().nextInt(0,  vertexes.size()-1);
				repeat = source == destiny;
			}
			
			long startTime = System.nanoTime();
			AlgoritmnAStar.BeamSearch(grafo, vertexes.get(source), vertexes.get(destiny),20);
			long endTime = System.nanoTime();
	
			System.out.println("Beam Search Tomo: "+(endTime - startTime)+" Nanosegundos");
			
			startTime = System.nanoTime();
			AlgoritmnAStar.AStar(grafo, vertexes.get(source), vertexes.get(destiny));
			endTime = System.nanoTime();
	
			System.out.println("AStar Tomo: "+(endTime - startTime)+" Nanosegundos");
		}
	}

	
	private static Graph<Integer, DefaultWeightedEdge> crearGrafoEnteros(){
        Graph<Integer, DefaultWeightedEdge> grafo = new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
       
        Integer a = new Integer(5);
        Integer b = new Integer(10);
        Integer c = new Integer(12);
        Integer d = new Integer(8);
        Integer e = new Integer(15);
        Integer f = new Integer(20);
        Integer g = new Integer(38);
        Integer h = new Integer(25);
        Integer i = new Integer(30);
        Integer j = new Integer(27);
        Integer k = new Integer(55);
        Integer l = new Integer(65);
        Integer m = new Integer(58);
        Integer n = new Integer(62);
        Integer enie = new Integer(110);
        Integer o = new Integer(120);
        Integer p = new Integer(200);
       
        grafo.addVertex(a);
        grafo.addVertex(b);
        grafo.addVertex(c);
        grafo.addVertex(d);
        grafo.addVertex(e);
        grafo.addVertex(f);
        grafo.addVertex(g);
        grafo.addVertex(h);
        grafo.addVertex(i);
        grafo.addVertex(j);
        grafo.addVertex(k);
        grafo.addVertex(l);
        grafo.addVertex(m);
        grafo.addVertex(n);
        grafo.addVertex(enie);
        grafo.addVertex(o);
        grafo.addVertex(p);
       
        DefaultWeightedEdge edge1 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge2 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge3 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge4 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge5 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge6 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge7 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge8 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge9 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge10 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge11 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge12 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge13 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge14 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge15 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge16 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge17 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge18 = new DefaultWeightedEdge();
        DefaultWeightedEdge edge19 = new DefaultWeightedEdge();
       
        grafo.addEdge(a, b, edge1);
        grafo.addEdge(a, c, edge2);
        grafo.addEdge(a, d, edge3);
        grafo.addEdge(b, e, edge4);
        grafo.addEdge(b, f, edge5);
        grafo.addEdge(e, k, edge6);
        grafo.addEdge(f, l, edge7);
        grafo.addEdge(k, enie, edge8);
        grafo.addEdge(l, enie, edge9);
        grafo.addEdge(c, g, edge10);
        grafo.addEdge(c, h, edge11);
        grafo.addEdge(g, o, edge12);
        grafo.addEdge(h, m, edge13);
        grafo.addEdge(m, o, edge14);
        grafo.addEdge(m, p, edge15);
        grafo.addEdge(d, i, edge16);
        grafo.addEdge(d, j, edge17);
        grafo.addEdge(j, n, edge18);
        grafo.addEdge(i, p, edge19);
       
       
        grafo.setEdgeWeight(edge1, 2);
        grafo.setEdgeWeight(edge2, 3);
        grafo.setEdgeWeight(edge3, 4);
        grafo.setEdgeWeight(edge4, 1);
        grafo.setEdgeWeight(edge5, 5);
        grafo.setEdgeWeight(edge6, 10);
        grafo.setEdgeWeight(edge7, 12);
        grafo.setEdgeWeight(edge8, 15);
        grafo.setEdgeWeight(edge9, 20);
        grafo.setEdgeWeight(edge10, 2);
        grafo.setEdgeWeight(edge11, 3);
        grafo.setEdgeWeight(edge12, 25);
        grafo.setEdgeWeight(edge13, 12);
        grafo.setEdgeWeight(edge14, 20);
        grafo.setEdgeWeight(edge15, 25);
        grafo.setEdgeWeight(edge16, 4);
        grafo.setEdgeWeight(edge17, 5);
        grafo.setEdgeWeight(edge18, 10);
        grafo.setEdgeWeight(edge19, 25);
        return grafo;
    }

}
