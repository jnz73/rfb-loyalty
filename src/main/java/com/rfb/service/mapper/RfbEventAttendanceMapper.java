package com.rfb.service.mapper;

import com.rfb.domain.*;
import com.rfb.service.dto.RfbEventAttendanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RfbEventAttendance and its DTO RfbEventAttendanceDTO.
 */
@Mapper(componentModel = "spring", uses = {RfbEventMapper.class, RfbUserMapper.class})
public interface RfbEventAttendanceMapper extends EntityMapper<RfbEventAttendanceDTO, RfbEventAttendance> {

    @Mapping(source = "rfbEvent.id", target = "rfbEventId")
    @Mapping(source = "rfbuser.id", target = "rfbuserId")
    RfbEventAttendanceDTO toDto(RfbEventAttendance rfbEventAttendance);

    @Mapping(source = "rfbEventId", target = "rfbEvent")
    @Mapping(source = "rfbuserId", target = "rfbuser")
    RfbEventAttendance toEntity(RfbEventAttendanceDTO rfbEventAttendanceDTO);

    default RfbEventAttendance fromId(Long id) {
        if (id == null) {
            return null;
        }
        RfbEventAttendance rfbEventAttendance = new RfbEventAttendance();
        rfbEventAttendance.setId(id);
        return rfbEventAttendance;
    }
}
