package Repository;

import Domain.Floor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FloorRepo {
    private List<Floor> floorList;

    {
        this.floorList = new ArrayList<>();
    }
    public Floor getFloorByNumber(Integer floorNumber){
        return floorList
                .stream()
                .filter(getFloorPredicate(floorNumber))
                .findFirst()
                .get();
    }

    public void generateFloors(int numberOfFloors) {
        IntStream.
                range(1, numberOfFloors+1).
                forEach(i -> addFloor(new Floor(i)));
    }

    public List<Floor> getFloors() {
        return floorList;
    }

    private Predicate<Floor> getFloorPredicate(Integer floorNumber) {
        return floor -> floor.getFloorNumber().equals(floorNumber);
    }

    private void addFloor(Floor floor){
        floorList.add(floor);
    }
}
