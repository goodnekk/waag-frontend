(ns waag.newcard
  (:require [waag.mth :as mth]
            [waag.state :as state]
            [waag.reusable :as reusable]))

;;menu
(def menu (mth/mcomp
    (fn [vnode] (mth/m ".menubar"
                       [(mth/m "span.menu-button"
                               {:onclick (fn [e] (state/gotoPage :home))}
                               "<")
                        (mth/m "span.menu-title" "nieuwe kaart")
                         ]))))
;;title input
(def titleInput (mth/mcomp
    (fn [vnode] (mth/m ".menubar"
                       [(mth/m "h1" "Wat zou je willen verbeteren?")

                        (mth/m "textarea"
                               {:value (state/getNewCard :name)
                                :oninput (fn [e] (state/setNewName e.target.value))})

                        (mth/m ".next-button"
                               {:onclick (fn [e] (state/gotoPage :newcard 1))}
                               ">")]))))


;;title input
(def categoryInput (mth/mcomp
    (fn [vnode] (mth/m ".menubar"
                       [(mth/m "h1" "Selecteer een categorie")

                        (mth/m ".card-categories" (map (fn [c] (mth/m ".card-category" c))
                                                       (deref state/categories)))

                        (mth/m ".card-preview" (state/getNewCard :name))

                        (mth/m ".next-button"
                               {:onclick (fn [e] ((state/gotoPage :newcard 1)))}
                               ">")]))))

;;homepage
(def main (mth/mcomp
    (fn [vnode] (mth/m ".whitepage"
                       [(mth/m menu)
                        (case (first (state/getPageParams))
                          0 (mth/m titleInput)
                          1 (mth/m categoryInput))]))))
