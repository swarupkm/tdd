package Domain;

import java.util.List;
import java.util.Objects;

public class Floor {
    private final Integer floorNumber;
    private List<Person> personList;

    public Floor(Integer floorNumber){
        this.floorNumber = floorNumber;
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public void removePerson(Person person){
        personList.remove(person);
    }

    public Integer getFloorNumber(){
        return floorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return Objects.equals(floorNumber, floor.floorNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(floorNumber);
    }
}
