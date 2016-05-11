package ch.helin.messages.dto.message.missionMessage;

/**
 * After the drone Operator accepted the with ConfirmMissionMessage,
 * the server has to Confirm the mission again, in order to know that
 * the server hasn't reasigned the mission to an other drone in the meantime.
 */
public class FinalAssignMissionMessage extends AssignMissionMessage {

}
