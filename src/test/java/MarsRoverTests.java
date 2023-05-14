import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverTests {

    @Test
    public void testMoveForwardOneTimeLeftEdgeToRightEdge() {

        // Both case with EAST and WEST directions
        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover roverW = new MarsRoverImpl(new Point2d(0, 3), Direction.WEST);
        MarsRover roverE = new MarsRoverImpl(new Point2d(5, 3), Direction.EAST);
        //Act
        roverW.move("f");
        roverE.move("f");
        //Assert
        Assertions.assertEquals(new Point2d(5, 3), roverW.getCurrentPosition());
        Assertions.assertEquals(new Point2d(0, 3), roverE.getCurrentPosition());
    }

    @Test
    public void testMoveBackwardOneTimeLeftEdgeToRightEdge() {
        // Both case with EAST and WEST directions
        MarsRover roverW = new MarsRoverImpl(new Point2d(5, 3), Direction.WEST);
        MarsRover roverE = new MarsRoverImpl(new Point2d(0, 3), Direction.EAST);
        roverW.move("b");
        roverE.move("b");
        Assertions.assertEquals(new Point2d(0, 3), roverW.getCurrentPosition());
        Assertions.assertEquals(new Point2d(5, 3), roverE.getCurrentPosition());
    }

    @Test
    public void testMoveForwardOneTimeNorthEdgeToSouthEdge(){
        // Both case with NORTH and SOUTH directions
        MarsRover roverN = new MarsRoverImpl(new Point2d(3, 5), Direction.NORTH);
        MarsRover roverS = new MarsRoverImpl(new Point2d(3, 0), Direction.SOUTH);
        roverN.move("f");
        roverS.move("f");
        Assertions.assertEquals(new Point2d(3, 0), roverN.getCurrentPosition());
        Assertions.assertEquals(new Point2d(3, 5), roverS.getCurrentPosition());
    }

    @Test
    public void testMoveBackwardOneTimeNorthEdgeToSouthEdge(){
        // Both case with NORTH and SOUTH directions
        MarsRover roverN = new MarsRoverImpl(new Point2d(3, 0), Direction.NORTH);
        MarsRover roverS = new MarsRoverImpl(new Point2d(3, 5), Direction.SOUTH);
        roverN.move("b");
        roverS.move("b");
        Assertions.assertEquals(new Point2d(3, 5), roverN.getCurrentPosition());
        Assertions.assertEquals(new Point2d(3, 0), roverS.getCurrentPosition());
    }

    @Test
    public void testOneStepForward() {
        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Point2d(1, 1), Direction.NORTH);

        //Act
        rover.move("f");

        //Assert
        Assertions.assertEquals(new Point2d(1, 2), rover.getCurrentPosition());
    }

    @Test
    public void testTwoStepsForward() {
        MarsRover rover = new MarsRoverImpl(new Point2d(2, 3), Direction.SOUTH);
        rover.move(("ff"));
        Assertions.assertEquals(new Point2d(2, 1), rover.getCurrentPosition());
    }

    @Test
    public void testOneStepBackward() {
        MarsRover rover = new MarsRoverImpl(new Point2d(2, 2), Direction.EAST);
        rover.move(("b"));
        Assertions.assertEquals(new Point2d(1, 2), rover.getCurrentPosition());
    }

    @Test
    public void testTwoStepBackwardLeft() {
        MarsRover rover = new MarsRoverImpl(new Point2d(2, 2), Direction.SOUTH);
        rover.move(("bl"));
        Assertions.assertEquals(new Point2d(2, 3), rover.getCurrentPosition());
    }
}
