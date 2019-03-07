import java.util.*;

class Answer{
	String val;
}

public class FindStringPath{

	static String find_path(List<List<String>> matrix, String target_string){
		int rows = matrix.size();
		int cols = matrix.get(0).size();
		boolean [][] visited = new boolean[rows][cols];
		List<String> paths = new ArrayList<>();
		Answer a = new Answer();
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				if(matrix.get(i).get(j).equalsIgnoreCase(target_string.charAt(0)+"") && visited[i][j] == false){
					dfsUtil(matrix, visited, target_string, paths, i, j, 1, ""+target_string.charAt(0), rows, cols, a);
				}
			}
		}
		if(a.val != null){
			return a.val;
		}
		return "NO PATH";
	}


	private static void dfsUtil(List<List<String>> matrix, boolean[][] visited, String target_string, List<String> paths, int row, int col, int index, String current, int totalRows, int totalCols, Answer a){
		if(current.equalsIgnoreCase(target_string)){
			String ans = "";
			for(String s : paths){
				ans += s;
			}
			a.val = ans;
		}

		// right
		if(isSafe(row, col+1, totalRows, totalCols)){
			if(visited[row][col+1] == false && matrix.get(row).get(col+1).equalsIgnoreCase(target_string.charAt(index)+"")){
				paths.add("R");
				dfsUtil(matrix, visited, target_string, paths, row, col+1, index+1,current+matrix.get(row).get(col+1), totalRows, totalCols, a);
				paths.remove(paths.size()-1);
			}
		}
		// down
		if(isSafe(row+1, col, totalRows, totalCols)){
			if(visited[row+1][col] == false && matrix.get(row+1).get(col).equalsIgnoreCase(target_string.charAt(index)+"")){
				paths.add("D");
				dfsUtil(matrix,visited, target_string, paths, row+1, col, index+1,current+matrix.get(row+1).get(col), totalRows, totalCols, a);
				paths.remove(paths.size()-1);
			}
		}

	}

	private static boolean isSafe(int row, int col, int totalRows, int totalCols){
		if(row < 0 || row > totalRows-1){
			return false;
		}

		if(col < 0 || col > totalCols-1){
			return false;
		}

		return true;
	}

	public static void main(String [] args){
		List<List<String>> matrix = new ArrayList<>();
		matrix.add(new ArrayList<String>(){{add("a");add("b");add("j");add("d");}});
		matrix.add(new ArrayList<String>(){{add("n");add("j");add("k");add("m");}});
		matrix.add(new ArrayList<String>(){{add("e");add("f");add("q");add("z");}});

		String target_string = "abjkqz";
		System.out.println(find_path(matrix, target_string));
	}

}