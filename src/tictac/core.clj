(ns tictac.core)

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

(defn checkValidUsertype [slot]
       (or (= slot "H") (= slot "M") )
)

(defn checkSingleSlot [idx itm] 
     (if (checkValidUsertype itm)
         true
         (= (str idx) itm)
     )
)
;; check if curstate has only valid characters like "H","M", or "1","2"...
(defn checkCurStateCharValid 
  "check if curstate vector has only valid characters like 'H'or'M', or '1'or'2'..."
  [curstate]
      (not    (some false? 
                (map-indexed checkSingleSlot curstate)
              )
      )        
)

(def invalidState ["0" "1" "2" "H" "M" "2" "M" "7" "l"])
;;(checkCurStateCharValid invalidState) return false
;;(checkCurStateCharValid onestepWinState) return true

(defn userTypeCount
     "gets the count of given usertype in
       curState vector"
      [curState usertype]      
      (count (filter #(= usertype %) curState))
)      
  

(defn checkCurStateValid
   "check if curstate vector is in valid state
     count of 'H' should be either 
       a) equal to count of 'M'
       b) 1 less than count of 'M'
       c) 1 greater than count of 'M'"
   [curState]
   (let [Hcount (userTypeCount curState "H")
         Mcount (userTypeCount curState "M")
         DiffCount (- Hcount Mcount)
        ]
     (if (or (= DiffCount 0)
             (= DiffCount 1)
             (= DiffCount -1))
        true ;; valid state
        false ;; invalid state
     )
   )
)

           
                
  