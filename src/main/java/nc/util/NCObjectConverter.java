package nc.util;

import nc.entity.*;
import nc.entity.impl.*;
import nc.util.batchsqlquery.BatchSqlCreatorContext;
import nc.util.batchsqlquery.impl.ClubBatchSqlCreator;
import nc.util.batchsqlquery.impl.DivisionBatchSqlCreator;
import nc.util.batchsqlquery.impl.PlayerBatchSqlCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by petka on 28.03.2017.
 *
 * @author Evgeniy Tupikov
 */
public final class NCObjectConverter {

    public static final String CLUB_TYPE_ID = "0bbfc4e4-10b9-11e7-83f0-b888e3a0097b";
    public static final String DIVISION_TYPE_ID = "0be36ff0-10b9-11e7-83f0-b888e3a0097b";
    public static final String PLAYER_TYPE_ID = "0be38f6b-10b9-11e7-83f0-b888e3a0097b";

    public static ObjectEntity toNCObject(Club club) {
        ObjectEntity objectEntity = new ObjectEntity();
        objectEntity.setId(club.getId() == null ? null : club.getId());
        objectEntity.setObjectType(new ObjectType(CLUB_TYPE_ID));
        objectEntity.setName(club.getName());
        List<ParamEntity> paramList = new ArrayList<>();
        paramList.add(new ParamEntity(objectEntity, new AttributeEntity("ad184d56-10b9-11e7-83f0-b888e3a0097b"), club.getName()));
        paramList.add(new ParamEntity(objectEntity, new AttributeEntity("ad18652a-10b9-11e7-83f0-b888e3a0097b"), club.getCity()));
        objectEntity.setParamEntityList(paramList);
        return objectEntity;
    }

    public static ObjectEntity toNCObject(Division division) {
        ObjectEntity objectEntity = new ObjectEntity();
        objectEntity.setId(division.getId() == null ? null : division.getId());
        objectEntity.setObjectType(new ObjectType(DIVISION_TYPE_ID));
        objectEntity.setName(division.getName());
        List<ParamEntity> paramList = new ArrayList<>();
        paramList.add(new ParamEntity(objectEntity, new AttributeEntity("ad186ff1-10b9-11e7-83f0-b888e3a0097b"), division.getName()));
        objectEntity.setParamEntityList(paramList);
        return objectEntity;
    }

    public static ObjectEntity toNCObject(Player player) {
        ObjectEntity objectEntity = new ObjectEntity();
        objectEntity.setId(player.getId() == null ? null : player.getId());
        objectEntity.setObjectType(new ObjectType(PLAYER_TYPE_ID));
        objectEntity.setName(player.getLastName());
        List<ParamEntity> paramList = new ArrayList<>();
        paramList.add(new ParamEntity(objectEntity, new AttributeEntity("ad2b074c-10b9-11e7-83f0-b888e3a0097b"), player.getFirstName()));
        paramList.add(new ParamEntity(objectEntity, new AttributeEntity("ad2b22cd-10b9-11e7-83f0-b888e3a0097b"), player.getLastName()));
        paramList.add(new ParamEntity(objectEntity, new AttributeEntity("ad2b3a78-10b9-11e7-83f0-b888e3a0097b"), player.getAge()));
        objectEntity.setParamEntityList(paramList);
        return objectEntity;
    }

    public static Club toClub(ObjectEntity objectEntity){
        Club club = new ClubImpl();

        club.setId(objectEntity.getId());
        club.setName(objectEntity.getName());
        if (!objectEntity.getParamEntityList().isEmpty()) {
            for (ParamEntity paramEntity : objectEntity.getParamEntityList()) {
                if (paramEntity.getAttributeId().getAttributeName().equals("City")) {
                    club.setCity(paramEntity.getStringValue());
                }
            }
        }
        return club;
    }

    public static Division toDivision(ObjectEntity objectEntity) {
        Division division = new DivisionImpl();
        division.setId(objectEntity.getId());
        division.setName(objectEntity.getName());
        return division;
    }

    public static Player toPlayer(ObjectEntity objectEntity) {
        Player player = new PlayerImpl();
        player.setId(objectEntity.getId());
        if (!objectEntity.getParamEntityList().isEmpty()) {
            for (ParamEntity paramEntity : objectEntity.getParamEntityList()) {
                switch (paramEntity.getAttributeId().getAttributeName()) {
                    case "First name":
                        player.setFirstName(paramEntity.getStringValue());
                        break;
                    case "Last name":
                        player.setLastName(paramEntity.getStringValue());
                        break;
                    case "Age":
                        player.setAge(paramEntity.getNumberValue());
                        break;
                    default:
                        break;
                }
            }
        }
        return player;
    }
}
