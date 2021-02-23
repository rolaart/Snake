package snake;
import java.util.LinkedList;

/**
 *
 * @author Ivelina Balcheva
 */
public class Game 
{
    private LinkedList<Cell> snakePartList = new LinkedList<>();
    private Cell head;
    
    public Game(Cell initPos)
    {
        head = initPos;
        snakePartList.add(head);
    }
    
    public void grow()
    {
        snakePartList.add(head);
    }
    
    public void move(Cell nextCell)
    {
        System.out.println("Snake moving to " + nectCell.getRow() + " " + nextCell.getCol());
        Cell tail = snakePartList.removeLast();
        tail.setCellType(CellType.EMPTY);
        
        head = nextCell;
        snakePartList.addFirst(head);
    }
    
    public boolean checkCrash(cell nextCell)
    {
        System.out.println("Checking for crash");
        for(Cell cell : snakePartList)
        {
            if(cell == nectCell)
                return true;
        }
        return false;
    }
    
    public LinkedList<Cell> getSnakePartList()
    {
        return snakePartList;
    }
    
    public void setSnakePartList(LinkedList<Cell> snakePartList)
    {
        this.snakePartList = snakePartList;
    }
    
    public Cell getHead()
    {
        return head;
    }
    
    public void setHead(Cell head)
    {
        this.head = head;
    }
}
