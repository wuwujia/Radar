package pubg.radar.struct.cmd

import com.badlogic.gdx.math.Vector2
import pubg.radar.GameListener
import pubg.radar.register
import pubg.radar.struct.Actor
import pubg.radar.struct.Bunch
import pubg.radar.struct.cmd.CMD.propertyBool
import pubg.radar.struct.cmd.CMD.propertyByte
import pubg.radar.struct.cmd.CMD.propertyFloat
import pubg.radar.struct.cmd.CMD.propertyInt
import pubg.radar.struct.cmd.CMD.propertyName
import pubg.radar.struct.cmd.CMD.propertyObject
import pubg.radar.struct.cmd.CMD.propertyString
import pubg.radar.struct.cmd.CMD.propertyVector

object GameStateCMD : GameListener {
    init {
        register(this)
    }

    override fun onGameOver() {
        SafetyZonePosition.setZero()
        SafetyZoneRadius = 0f
        SafetyZoneBeginPosition.setZero()
        SafetyZoneBeginRadius = 0f
        PoisonGasWarningPosition.setZero()
        PoisonGasWarningRadius = 0f
        RedZonePosition.setZero()
        RedZoneRadius = 0f
        TotalWarningDuration = 0f
        ElapsedWarningDuration = 0f
        TotalReleaseDuration = 0f
        ElapsedReleaseDuration = 0f
        NumJoinPlayers = 0
        NumAlivePlayers = 0
        NumAliveTeams = 0
        RemainingTime = 0
        MatchElapsedMinutes = 0

    }

    var TotalWarningDuration = 0f
    var ElapsedWarningDuration = 0f
    private var RemainingTime = 0
    var MatchElapsedMinutes = 0
    val SafetyZonePosition = Vector2()
    var SafetyZoneRadius = 0f
    private val SafetyZoneBeginPosition = Vector2()
    private var SafetyZoneBeginRadius = 0f
    val PoisonGasWarningPosition = Vector2()
    var PoisonGasWarningRadius = 0f
    val RedZonePosition = Vector2()
    var RedZoneRadius = 0f
    private var TotalReleaseDuration = 0f
    private var ElapsedReleaseDuration = 0f
    private var NumJoinPlayers = 0
    var NumAlivePlayers = 0
    var NumAliveTeams = 0

     fun process(actor: Actor, bunch: Bunch, repObj: NetGuidCacheObject?, waitingHandle: Int, data: HashMap<String, Any?>): Boolean {
        with(bunch) {
            when (waitingHandle) {
                16 -> {
                    //  struct FString MatchId;
                    // 0x0410(0x0010) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient)

                    val MatchId = propertyString()
                    val b = MatchId

                }
                17 -> {
                    //  struct FString MatchShortGuid;                                           // 0x0420(0x0010) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient)

                    val MatchShortGuid = propertyString()
                    val b = MatchShortGuid

                }
                18 -> {
                    //  bool bIsCustomGame;                                            // 0x0430(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                }
                19 -> {
                    //   bool bIsWinnerZombieTeam;                                      // 0x0431(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                }
                20 -> {
                    //   unsigned char                                      UnknownData00[0x2]
                    // 0x0432(0x0002) MISSED OFFSET
                }
                21 -> {
                    //  int                                                NumTeams
                };                                                 // 0x0434(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                22 -> {
                    //   int                                                RemainingTime
                };                                            // 0x0438(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                23 -> {
                    //   int                                                MatchElapsedMinutes
                };                                      // 0x043C(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                24 -> {
                    //   bool                                               bTimerPaused
                };                                             // 0x0440(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                25 -> {
                    //   bool                                               bShowLastCircleMark
                };                                      // 0x0441(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                26 -> {
                    //   bool                                               bCanShowLastCircleMark
                };                                   // 0x0442(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                27 -> {
                    //   unsigned char                                      UnknownData01[0x1]
                };                                       // 0x0443(0x0001) MISSED OFFSET
                28 -> {
                    NumJoinPlayers = propertyInt()

                    //   int                                                NumJoinPlayers
                };                                           // 0x0444(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                29 -> {
                    //   int                                                NumAlivePlayers

                    NumAlivePlayers = propertyInt()

                };                                          // 0x0448(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                30 -> {
                    // int NumAliveZombiePlayers
                    val NumAliveZombiePlayers = propertyInt()
                    val b = NumAliveZombiePlayers


                };                                    // 0x044C(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                31 -> {
                    //   int                                            NumAliveTeams

                    NumAliveTeams = propertyInt()

                };                                            // 0x0450(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                32 -> {
                    //   int                                                NumStartPlayers

                    val NumStartPlayers = propertyInt()
                    val b = NumStartPlayers

                };                                          // 0x0454(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                33 -> {
                    //   int                                                NumStartTeams

                    val NumStartTeams = propertyInt()
                    val b = NumStartTeams

                };                                            // 0x0458(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                34 -> {
                    //   struct FVector                                     SafetyZonePosition

                    val pos = propertyVector()
                    SafetyZonePosition.set(pos.x, pos.y)

                };                                       // 0x045C(0x000C) (BlueprintVisible, Net, Transient, IsPlainOldData)
                35 -> {
                    //   float                                              SafetyZoneRadius

                    SafetyZoneRadius = propertyFloat()

                };                                         // 0x0468(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                36 -> {
                    //   struct FVector                                     PoisonGasWarningPosition




                };                                 // 0x046C(0x000C) (BlueprintVisible, Net, Transient, IsPlainOldData)
                37 -> {
                    //   float                                              PoisonGasWarningRadius
                };                                   // 0x0478(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                38 -> {
                    //   struct FVector                                     RedZonePosition
                };                                          // 0x047C(0x000C) (BlueprintVisible, Net, Transient, IsPlainOldData)
                39 -> {
                    //   float                                              RedZoneRadius
                };                                            // 0x0488(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                40 -> {
                    //   struct FVector2D                                   LastCirclePosition
                };                                       // 0x048C(0x0008) (BlueprintVisible, Net, Transient, IsPlainOldData)
                41 -> {
                    //   float                                              TotalReleaseDuration
                };                                     // 0x0494(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                42 -> {
                    //   float                                              ElapsedReleaseDuration
                };                                   // 0x0498(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                43 -> {
                    //   float                                              TotalWarningDuration
                };                                     // 0x049C(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                44 -> {
                    //    float                                              ElapsedWarningDuration
                };                                   // 0x04A0(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                45 -> {
                    //    bool                                               bIsGasRelease
                };                                            // 0x04A4(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                46 -> {
                    //    bool                                               bIsTeamMatch
                };                                             // 0x04A5(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                47 -> {
                    //   bool                                               bIsZombieMode
                };                                            // 0x04A6(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                48 -> {
                    //    bool                                               bUseXboxUnauthorizedDevice
                };                               // 0x04A7(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                49 -> {
                    //   float                                              ElapsedGasReleaseDuration
                };                                // 0x04A8(0x0004) (BlueprintVisible, BlueprintReadOnly, ZeroConstructor, Transient, IsPlainOldData)
                50 -> {
                    //    struct FVector                                     LerpSafetyZonePosition
                };                                   // 0x04AC(0x000C) (BlueprintVisible, BlueprintReadOnly, Transient, IsPlainOldData)
                51 -> {
                    //   float                                              LerpSafetyZoneRadius
                };                                     // 0x04B8(0x0004) (BlueprintVisible, BlueprintReadOnly, ZeroConstructor, Transient, IsPlainOldData)
                52 -> {
                    //    struct FVector                                     SafetyZoneBeginPosition
                };                                  // 0x04BC(0x000C) (BlueprintVisible, Net, Transient, IsPlainOldData)
                53 -> {
                    //    float                                              SafetyZoneBeginRadius
                };                                    // 0x04C8(0x0004) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                54 -> {
                    //    EMatchStartType                                    MatchStartType
                };                                           // 0x04CC(0x0001) (Net, ZeroConstructor, Transient, IsPlainOldData)
                55 -> {
                    //   bool                                               bIsAnyoneKilled
                };                                          // 0x04CD(0x0001) (ZeroConstructor, IsPlainOldData)
                56 -> {
                    //   unsigned char                                      UnknownData02[0x42]
                };                                      // 0x04CE(0x0042) MISSED OFFSET
                57 -> {
                    //  class ALevelAttribute*                             LevelAttribute;                                           // 0x0510(0x0008) (ZeroConstructor, Transient, IsPlainOldData)
                }
                58 -> {
                    //    unsigned char                                      UnknownData03[0x8]
                };                                       // 0x0518(0x0008) MISSED OFFSET
                59 -> {
                    //  bool                                               bIsWarMode
                };                                               // 0x0520(0x0001) (BlueprintVisible, Net, ZeroConstructor, Transient, IsPlainOldData)
                60 -> {
                    //    unsigned char                                      UnknownData04[0x3]
                };                                       // 0x0521(0x0003) MISSED OFFSET
                61 -> {
                    //      int                                                GoalScore
                };                                                // 0x0524(0x0004) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                62 -> {
                    //      TArray<int>                                        TeamScores
                };                                               // 0x0528(0x0010) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient)
                63 -> {
                    //    int64_t                                            NextRespawnTimeTick
                };                                      // 0x0538(0x0008) (Edit, Net, ZeroConstructor, Transient, EditConst, IsPlainOldData)
                64 -> {
                    //     int64_t                                            TimeUpTick
                };                                               // 0x0540(0x0008) (Edit, Net, ZeroConstructor, Transient, EditConst, IsPlainOldData)
                65 -> {
                    //    bool                                               bIsTeamElimination
                };                                       // 0x0548(0x0001) (BlueprintVisible, BlueprintReadOnly, Net, ZeroConstructor, Transient, IsPlainOldData)
                66 -> {
                    //     unsigned char                                      UnknownData05[0x7]
                };                                       // 0x0549(0x0007) MISSED OFFSET
                67 -> {
                    //    class UTimerTextBlockUpdater*                      RespawnTimerUpdater;                                      // 0x0550(0x0008) (ZeroConstructor, IsPlainOldData)
                }
                68 -> {
                    //     class UTimerTextBlockUpdater*                      TimeUpTimerUpdater;                                       // 0x0558(0x0008) (ZeroConstructor, IsPlainOldData)
                }
                69 -> {
                    //   unsigned char                                      UnknownData06[0xC0]
                };
                70 -> return false
                else -> return false
            }
            return true
        }
    }
}
