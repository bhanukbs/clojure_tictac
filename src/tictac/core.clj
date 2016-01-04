(ns tictac.core)


 ;;  basic data structure for prog
(def initState [ "a1" "a2" "a3"
                 "b1" "b2" "b3"
                 "c1" "c2" "c3"])

;; win states
(def winState [  ;horizontal case
                 ["a1" "a2" "a3"] 
                 ["b1" "b2" "b3"]
                 ["c1" "c2" "c3"]
                 ;vertical case
                 ["a1" "b1" "c1"]
                 ["a2" "b2" "c2"]
                 ["a3" "b3" "c3"]
                 ;X case
                 ["a1" "b2" "c3"]
                 ["a3" "b2" "c1"]
            ]
  )

;;(map #(str % "M") ["a1" "a2" "a3"] ) --> ("a1M" "a2M" "a3M")
(defn attachUsertype [usertype statevector ] 
          (vec 
            (map #(str % usertype) statevector )
               )
)

(defn userTypeWinStatesGenerator [usertype] 
  (vec
    (map (partial attachUsertype usertype) winState)
  )
)

(def HumanWinStates (userTypeWinStatesGenerator "H"))
(def MachineWinStates (userTypeWinStatesGenerator "M"))

(comment
 HumanWinStates
[["a1H" "a2H" "a3H"]
 ["b1H" "b2H" "b3H"]
 ["c1H" "c2H" "c3H"]
 ["a1H" "b1H" "c1H"]
 ["a2H" "b2H" "c2H"]
 ["a3H" "b3H" "c3H"]
 ["a1H" "b2H" "c3H"]
 ["a3H" "b2H" "c1H"]]
;;=> MachineWinStates
[["a1M" "a2M" "a3M"]
 ["b1M" "b2M" "b3M"]
 ["c1M" "c2M" "c3M"]
 ["a1M" "b1M" "c1M"]
 ["a2M" "b2M" "c2M"]
 ["a3M" "b3M" "c3M"]
 ["a1M" "b2M" "c3M"]
 ["a3M" "b2M" "c1M"]]
  );; comment over

;;------
