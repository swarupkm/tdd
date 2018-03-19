package Repository;

import Domain.Floor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FloorRepoTest {

    private FloorRepo floorRepo;

    @Before
    public void setup(){
        floorRepo = new FloorRepo();
    }

    @Test
    public void should_get_floor_based_on_floor_number() {
        floorRepo.generateFloors(3);
        assertThat(floorRepo.getFloorByNumber(2), is(new Floor(2)));
    }

    @Test
    public void should_generate_floors(){
        floorRepo.generateFloors(2);
        List<Floor> expectedFloorsList = new ArrayList<>();
        expectedFloorsList.add(new Floor(1));
        expectedFloorsList.add(new Floor(2));
        assertThat(floorRepo.getFloors() , is(expectedFloorsList));
    }
}
