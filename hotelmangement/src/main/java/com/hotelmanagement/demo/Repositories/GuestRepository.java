package com.hotelmanagement.demo.Repositories;
import com.hotelmanagement.demo.Models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

    @Query(value = "select * from guest where guest_status = 'booking'", nativeQuery = true)
    List<Guest>getBookedGuest();

    @Query(value = "select * from guest WHERE guest_id = :g", nativeQuery = true)
    Guest getGuest(Integer g);
    @Query(value = "select guest_status from guest WHERE guest_id = :g", nativeQuery = true)
    String getStatus(Integer g);

    @Modifying
    @Transactional
    @Query(value = "UPDATE guest SET guest_status = 'check out'  WHERE guest_id = :g",nativeQuery = true)
    void checkOutById(Integer g);

    @Modifying
    @Transactional
    @Query(value = "UPDATE guest SET guest_status = 'check in'  WHERE guest_id = :g",nativeQuery = true)
    void checkInById(Integer g);


// delete booking (to delete guest later
    @Modifying
    @Transactional
    @Query(value = "DELETE from booking where fk_booking_id = :g",nativeQuery = true )
    void deleteBookingById(Integer g);
    @Modifying
    @Transactional
    @Query(value = "DELETE from guest where guest_id = :g",nativeQuery = true )
    void deleteGuestById(Integer g);


    @Query(value = "SELECT availability_status from room where room_no = :roomNum", nativeQuery = true)
    String getRoomStatus(Integer roomNum);

    // use when booking room/ adding guest
    @Modifying
    @Transactional
    @Query(value = "UPDATE room SET availability_status = 'Unavailable'  WHERE room_no = :roomNum",nativeQuery = true)
    void takeRoom(Integer roomNum);

    // use when checking out/ cancelling booking(delete guest)
    @Modifying
    @Transactional
    @Query(value = "UPDATE room SET availability_status = 'Available'  WHERE room_no = :roomNum",nativeQuery = true)
    void releaseRoom(Integer roomNum);



}
