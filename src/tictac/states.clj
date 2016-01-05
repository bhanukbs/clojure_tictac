(ns tictac.states)

;; initial game state
(def initialState ["0" "1" "2"
                   "3" "4" "5"
                   "6" "7" "8"])


;; an example of game not over state
(def notOverState ["M" "H" "M"
                   "H" "H" "5"
                   "M" "M" "H"])

;; an example of machine Win State
(def mWinState ["0" "1" "M"
                "3" "M" "5"
                "M" "7" "8"])

;; an example of one step to a machine Win State
(def onestepWinState ["0" "1" "2"
                      "H" "M" "H"
                      "M" "7" "H"])


(defn matchThreePositions
    "takes currentState vector, 
           position integers p1,p2 and p3
    and usertype character (H or M)   , return true if same usertype is found in
    p1,p2 and p3"
    
    [curState p1 p2 p3 usertype]
    
    (= usertype
       (nth curState p1)
       (nth curState p2)
       (nth curState p3)
    )
)
;;(matchThreePositions mWinState  2 4 6 "M")  return true
;;(matchThreePositions mWinState  2 4 6 "H")  return false
                
  