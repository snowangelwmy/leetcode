/*
 * Test cases:
 * 1: Input:
 *    [1,1,1,1,0,0,0,0]
 *    [1,1,1,1,0,0,0,0]
 *    [1,1,1,1,1,1,1,1]
 *    [1,1,1,1,1,1,1,1]
 *    [1,1,1,1,0,0,0,0]
 *    [1,1,1,1,0,0,0,0]
 *    [1,1,1,1,0,0,0,0]
 *    [1,1,1,1,0,0,0,0]
 * Output:
 *    (false,false)
 *      topLeft: (true,true)
 *      topRight: (false,false)
 *        topLeft: (true,false)
 *        topRight: (true,false)
 *        bottomLeft: (true,true)
 *        bottomRight: (true,true)
 *      bottomLeft: (true,true)
 *      bottomRight: (true,false)
 *      
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
  public Node construct(int[][] grid) {
    if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0||grid.length!=grid[0].length||(grid.length&(grid.length-1))!=0) {
      return null;
    }

    return constructHelper(grid, 0, grid.length-1, 0, grid[0].length-1);
  }

  private Node constructHelper(int[][] grid, int rLow, int rHigh, int cLow, int cHigh) {
    if(isLeaf(grid, rLow, rHigh, cLow, cHigh)) {
      return new Node(grid[rLow][cLow]==1, true, null, null, null, null);
    } else {
      Node topLeft = constructHelper(grid, rLow, rLow+(rHigh-rLow)/2, cLow, cLow+(cHigh-cLow)/2);
      Node topRight = constructHelper(grid, rLow, rLow+(rHigh-rLow)/2, cLow+(cHigh-cLow)/2+1, cHigh);
      Node bottomLeft = constructHelper(grid, rLow+(rHigh-rLow)/2+1, rHigh, cLow, cLow+(cHigh-cLow)/2);
      Node bottomRight = constructHelper(grid, rLow+(rHigh-rLow)/2+1, rHigh, cLow+(cHigh-cLow)/2+1, cHigh);
      return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
  }

  private boolean isLeaf(int[][] grid, int rLow, int rHigh, int cLow, int cHigh) {
    int value = grid[rLow][cLow];
    for(int i=rLow; i<=rHigh; i++){
      for(int j=cLow; j<=cHigh; j++){
        if(grid[i][j]!=value) {
          return false;
        }
      }
    }
    return true;
  }
}