(ns clj-webauthn.handler.example
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response] 
            [clojure.java.io :as io]
            [integrant.core :as ig]))

(defmethod ig/init-key :clj-webauthn.handler/example [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok (io/resource "clj_webauthn/handler/example/example.html")]))
