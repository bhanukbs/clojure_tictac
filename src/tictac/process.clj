(ns tictac.process
  (:require tictac.core))



;;(defn doDefense curState tictac.core/HumanWinStates
;;  (
;;    )
;;)




(defn isRowsEqual? [curRow matchRow] 
               (reduce = (map = curRow matchRow))
               )

;;=> (isRowsEqual? ["a1H" "a2H" "a3H"] ["a1H" "a2H" "a3H"])
;;true
;;=> (isRowsEqual? ["a1H" "a2H" "a3M"] ["a1H" "a2H" "a3H"])
;;false
;;



