(ns soda-ash.contents.extra
  (:require-macros
   [soda-ash.macros :refer [defcomp]])
  (:require
   [soda-ash.template :as t]))



(def types
  [:default
   :images
   :text])


(def opts
  {:tag     :div
   :ui?     false
   :ui-name "extra"
   :types   types})


(defcomp "default" opts)
(defcomp "images" (assoc opts :type "images"))
(defcomp "text" (assoc opts :type "text"))
