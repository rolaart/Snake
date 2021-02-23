package snake;

/**
 *
 * @author Ivelina Balcheva
 */

public class Snake 
{
    public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1, DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
    private Game snake;
    private Board board;
    private int direction;
    private boolean gameOver;
    
    public Snake(Game snake, Board board)
    {
        this.snake = snake;
        this.board = board;
    }
    
    public Game getSNake()
    {
        return snake;
    }
    
    public void setSnake(Game snake)
    {
        this.snake = snake;
    }
    
    public Board getBoard()
    {
        return board;
    }
    
    public void setBoard(Board board)
    {
        this.board = board;
    }
    
    public boolean isGameOver()
    {
        return GameOver;
    }
    
    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
    }
    
    public int getDirection()
    {
        return direction;
    }
    
    public void setDirection(int direction)
    {
        this.direction = direction;
    }
    
    //Game updating
    public void update()
    {
        System.out.println("Updating...");
        if(!gmaeOver)
        {
            if(direction != DIRECTION_NONE)
            {
                Cell nectCell = getNextCell(snake.getHead());
                
                if(snake.checkCrash(nectCell))
                {
                    setDirection(DIRECTION_NONE);
                    gameOver = true;
                }
                else
                {
                    snake.move(nextCell);
                    if(nextCell.getCellType() == CellType.FOOD)
                    {
                        snake.grow();
                        board.generateFood();
                    }
                }
            }
        }
    }
    
    private Cell getNextCell(Cell currentPosition)
    {
        System.out.println("Finding next");
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();
        
        if(direction == DIRECTION_LEFT)
        {
            col--;
        }
        else if(direction == DIRECTION_RIGHT)
        {
            col++;
        }
        else if(direction == DIRECTION_DOWN)
        {
            row++;
        }
        else if(direction == DIRECTION_UP)
        {
            row--;
        }
        
        Cell nextCell = board.getCells()[row][col];
        
        return nextCell;
    }
    
    public static void main(String[] args)
    {
        System.out.println("Starting a game...");
        
        Cell initPos = new Cell(0,0);
        Game initSnake = new Snake(initPos);
        Board board = new Board(10,10);
        Snake newGame = new Snake(initSnake, board);
        newGame.gameOver = false;
        newGame.direction = DIRECTION_RIGHT;
        
        //testing went like:
        for(int i = 0; i < 5; i++)
        {
            if(i == 2)
                newGame.board.generateFood();
            newGame.update();
            if(i == 3)
                newGame.direction = DIRECTION_RIGHT;
            if(newGame.gameOver == true)
                break;
        }
    }
}
