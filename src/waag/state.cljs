(ns waag.state)

;;routing
(def page (atom [:newcard 0]))
(defn gotoPage [& args]
  (swap! page (fn [old] args))
)

(defn getPageParams []
  (rest (deref page))
)

;;newcard
(def newcard (atom {:name ""
                    :category "health"
                    :score 10}))

(defn setNewName [name]
  (swap! newcard (fn [old] (assoc old :name name))))

(defn getNewCard [key]
  ((deref newcard) key))

;;cards
(def mycards (atom [
                   {:name "The amount of time I have"
                    :category "humeur"
                    :score 5
                    :id 0}
                   {:name "The amount of headache I have"
                    :category ""
                    :score 5
                    :id 1}
                   {:name "The amount of plants I have"
                    :category "environment"
                    :score 10
                    :id 2}
                   {:name "The amount of backpain I have"
                    :category "health"
                    :score 10
                    :id 3}]))

(defn getCardsByCategory []
  (group-by :category (deref mycards)))

(defn getCardById [id]
  (first (filter (fn [c] (= (c :id) id))
                 (deref mycards))))

;;categories
(def categories (atom ["Humeur" "Team & Sociaal" "Voldoening" "Gezondheid" "Omgeving" "Organizatie"]))
