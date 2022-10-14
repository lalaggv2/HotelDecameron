package com.equipo5.reto3.entities.customDTO;

import com.equipo5.reto3.entities.Room;

public class CountRoom {

    private Long total;
    private Room room;

    public CountRoom(Long total, Room room) {
        this.total = total;
        this.room = room;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
