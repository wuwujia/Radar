package pubg.radar.struct.cmd

import pubg.radar.GameListener
import pubg.radar.deserializer.ROLE_MAX
import pubg.radar.register
import pubg.radar.struct.Actor
import pubg.radar.struct.Bunch
import pubg.radar.struct.NetworkGUID
import pubg.radar.struct.cmd.CMD.propertyBool
import pubg.radar.struct.cmd.CMD.propertyByte
import pubg.radar.struct.cmd.CMD.propertyFloat
import pubg.radar.struct.cmd.CMD.propertyInt
import pubg.radar.struct.cmd.CMD.propertyNetId
import pubg.radar.struct.cmd.CMD.propertyObject
import pubg.radar.struct.cmd.CMD.propertyString
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

object PlayerStateCMD : GameListener {
    init {
        register(this)
    }

    override fun onGameOver() {
        playerNames.clear()
        playerNumKills.clear()
        uniqueIds.clear()
        teamNumbers.clear()
        attacks.clear()
    }

    val playerNames = ConcurrentHashMap<NetworkGUID, String>()
    val playerNumKills = ConcurrentHashMap<NetworkGUID, Int>()
    val uniqueIds = ConcurrentHashMap<String, NetworkGUID>()
    val teamNumbers = ConcurrentHashMap<NetworkGUID, Int>()
    val attacks = ConcurrentLinkedQueue<Pair<NetworkGUID, NetworkGUID>>()//A -> B
    var selfID = NetworkGUID(0)
    var selfStateID = NetworkGUID(0)

    fun process(actor: Actor, bunch: Bunch, waitingHandle: Int): Boolean {
        with(bunch) {
            //item_dbg {"$actor"}
            //item_dbg {""}
            when (waitingHandle) {
                1 -> {
                    //int
                    //Ranking;
                    //0x0448(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
//indicate player's death
                    val Ranking = propertyInt()
                    //   println("${playerNames[actor.netGUID]}${actor.netGUID} Ranking=$Ranking")


                }
                2 -> {
                    //unsigned char
                    //UnknownData00[0x4];
                    //0x044C(0x0004) MISSED OFFSET


                }
                3 -> {
                    //struct FString
// AccountId;
// 0x0450(0x0010) (Net, ZeroConstructor)
                    val AccountId = propertyString()
                    //    println("${actor.netGUID} AccountId=$AccountId")


                }
                4 -> {
                    //unsigned char
// bKilled : 1;
// 0x0460(0x0001)


                }
                5 -> {
                    //unsigned char
// UnknownData01[0x7];
// 0x0461(0x0007) MISSED OFFSET


                }
                6 -> {
                    //struct FString
                    //ReportToken;
                    //0x0468(0x0010) (Net, ZeroConstructor, Transient)
                    val ReportToken = propertyString()
                    //   println("${actor.netGUID} ReportToken=$ReportToken")

                }
                7 -> {
                    //struct FEmoteBitArray
                    //EmoteBitArray;
// 0x0478(0x0020) (Net)


                }
                8 -> {
                    //bool
// bShowMapMarker;
// 0x0498(0x0001) (BlueprintVisible, ZeroConstructor, IsPlainOldData)


                }
                9 -> {
                    //unsigned char
                    //UnknownData02[0x3];
                    //0x0499(0x0003) MISSED OFFSET
                    val role = readInt(ROLE_MAX)

                }
                10 -> {
                    //struct FVector2D
// MapMarkerPosition;
                    //0x049C(0x0008) (BlueprintVisible, IsPlainOldData)


                }
                11 -> {
                    //unsigned char
// UnknownData03[0x4];
// 0x04A4(0x0004) MISSED OFFSET

                    readInt(ROLE_MAX)


                }
                12 -> {
                    //TArray<struct FReplicatedCastableItem>
// ReplicatedCastableItems;
                    //0x04A8(0x0010) (Net, ZeroConstructor, Transient)


                }
                13 -> {
                    //bool
                    //bEmptyReplicatedCastableItems;
                    //0x04B8(0x0001) (ZeroConstructor, IsPlainOldData)


                }
                14 -> {
                    //EObserverAuthorityType
// ObserverAuthorityType;
// 0x04B9(0x0001) (Net, ZeroConstructor, Transient, IsPlainOldData)
                    val ObserverAuthorityType = readInt(4)
                    //   println("${playerNames[actor.netGUID]}${actor.netGUID} ObserverAuthorityType=$ObserverAuthorityType")


                }
                15 -> {
                    //unsigned char
// UnknownData04[0x2];
// 0x04BA(0x0002) MISSED OFFSET


                }
                16 -> {
                    //int
// TeamNumber;
// 0x04BC(0x0004) (Net, ZeroConstructor, Transient, IsPlainOldData)
                    val teamNumber = readInt(100)
                    teamNumbers[actor.netGUID] = teamNumber
                    //      println("${playerNames[actor.netGUID]}${actor.netGUID} TeamNumber=$teamNumber")

                }
                17 -> {
                    //unsigned char
// bIsZombie : 1;
                    //0x04C0(0x0001) (Net, Transient)
                    val bIsZombie = propertyBool()
                    //     println("bIsZombie=$bIsZombie")


                }
                18 -> {
                    //unsigned char
                    //UnknownData05[0x7];
                    //0x04C1(0x0007) MISSED OFFSET
                    val name = propertyString()
                    playerNames[actor.netGUID] = name
//query(name)
                    println("${actor.netGUID} playerID=$name")


                }
                19 -> {
                    //struct FTslPlayerScores
                    //PlayerScores;
                    //0x04C8(0x0010) (BlueprintVisible, BlueprintReadOnly, Net, Transient)


                }
                20 -> {
                    //struct FTslPlayerStatistics
                    //PlayerStatistics;
                    //0x04D8(0x0004) (Net, Transient)


                }
                21 -> {
                    //struct FTslPlayerStatisticsForOwner
                    // PlayerStatisticsForOwner;
                    //0x04DC(0x0010) (Net, Transient)


                }
                22 -> {
                    //unsigned char
                    //UnknownData06[0xB4];
                    //0x04EC(0x00B4) MISSED OFFSET


                }
                23 -> {
                    //TArray<struct FReplicatedEquipableItem>
                    //ReplicatedEquipableItems;
                    //0x05A0(0x0010) (Net, ZeroConstructor, Transient)


                }
                24 -> {
                    //unsigned char
                    //UnknownData07[0x1C];
                    //0x05B0(0x001C) MISSED OFFSET

                    val uniqueId = propertyNetId()
                    uniqueIds[uniqueId] = actor.netGUID
                    println("2: ${playerNames[actor.netGUID]}${actor.netGUID} uniqueId=$uniqueId")

                }
                25 -> {
                    //unsigned char
                    // bQuitter : 1;
// 0x05CC(0x0001)


                }
                26 -> {
                    //unsigned char
                    // UnknownData08[0x12E];
// 0x05CD(0x012E) MISSED OFFSET

                    val uniqueId = propertyNetId()
                    uniqueIds[uniqueId] = actor.netGUID
                    println("1: ${playerNames[actor.netGUID]}${actor.netGUID} uniqueId=$uniqueId")


                }
                27 -> {
                    //bool
                    // bIsInAircraft;
                    //0x06FB(0x0001) (Net, ZeroConstructor, IsPlainOldData)
                    val bIsInAircraft = propertyBool()
                    //   println("${playerNames[actor.netGUID]}${actor.netGUID} bIsInAircraft=$bIsInAircraft")

                }
                28 -> {
                    //float
                    //LastHitTime;
                    //0x06FC(0x0004) (BlueprintVisible, Net, ZeroConstructor, IsPlainOldData)
                    val lastHitTime = propertyFloat()
                    //   println("${playerNames[actor.netGUID]}${actor.netGUID} lastHitTime=$lastHitTime")

                }
                29 -> {
                    //struct FString
                    //CurrentAttackerPlayerNetId;
                    //0x0700(0x0010) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor)
                    val currentAttackerPlayerNetId = propertyString()
                    attacks.add(Pair(uniqueIds[currentAttackerPlayerNetId]!!, actor.netGUID))
                    //println("${playerNames[actor.netGUID]}${actor.netGUID} currentAttackerPlayerNetId=$currentAttackerPlayerNetId")


                }
                else -> return false
            }
        }
        return true
    }
}