public class MarsRoverImpl implements MarsRover {

    Point2d point;
    Direction direction;
    public MarsRoverImpl(Point2d startingPoint, Direction startingDirection){
        //TODO implement
        point = startingPoint;
        direction = startingDirection;

    }

    @Override
    public void move(String commands){
        //TODO implement
        String[] steps = commands.split((""));


        for (int i = 0; i < steps.length; i++) {
            if (steps[i].equals("f")) {
                switch (direction) {
                    case WEST -> {
                        point = new Point2d(point.x()-1, point.y());
                        if(point.x() < 0) {
                            point = new Point2d(6+point.x(), point.y());
                        }
                    }
                    case EAST -> {
                        point = new Point2d(point.x()+1, point.y());
                        if(point.x() > 5) {
                            point = new Point2d(-6+point.x(), point.y());
                        }
                    }
                    case NORTH -> {
                        point = new Point2d(point.x(), point.y()+1);
                        if(point.y()>5){
                            point = new Point2d(point.x(), -6+ point.y());
                        }
                    }
                    case SOUTH -> {
                        point = new Point2d(point.x(), point.y()-1);
                        if(point.y()<0){
                            point = new Point2d(point.x(), 6+ point.y());
                        }
                    }
                }
            }
            if (steps[i].equals("b")) {
                switch (direction) {
                    case WEST -> {
                        point = new Point2d(point.x()+1, point.y());
                        if(point.x() > 5) {
                            point = new Point2d(-6+point.x(), point.y());
                        }
                    }
                    case EAST -> {
                        point = new Point2d(point.x()-1, point.y());
                        if(point.x() < 0) {
                            point = new Point2d(6+point.x(), point.y());
                        }
                    }
                    case NORTH -> {
                        point = new Point2d(point.x(), point.y()-1);
                        if(point.y() < 0) {
                            point = new Point2d(point.x(), 6+point.y());
                        }
                    }
                    case SOUTH -> {
                        point = new Point2d(point.x(), point.y()+1);
                        if(point.y()>5){
                            point = new Point2d(point.x(), -6+ point.y());
                        }
                    }
                }
            }
            if (steps[i].equals("l")) {
                switch (direction) {
                    case WEST -> direction = Direction.SOUTH;
                    case EAST -> direction = Direction.NORTH;
                    case NORTH -> direction = Direction.WEST;
                    case SOUTH -> direction = Direction.EAST;
                }
            }
            if (steps[i].equals("r")) {
                switch (direction) {
                    case WEST -> direction = Direction.NORTH;
                    case EAST -> direction = Direction.SOUTH;
                    case NORTH -> direction = Direction.EAST;
                    case SOUTH -> direction = Direction.WEST;
                }
            }
        }
    }

    @Override
    public Point2d getCurrentPosition() {
        //TODO implement
        return point;
    }
}
