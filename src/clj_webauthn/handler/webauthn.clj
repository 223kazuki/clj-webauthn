(ns clj-webauthn.handler.webauthn
  (:require [ataraxy.core :as ataraxy]
            [ataraxy.response :as response]
            [integrant.core :as ig])
  (:import [com.yubico.webauthn.meta VersionInfo]))

(str (VersionInfo/getInstance))

(defmethod ig/init-key :clj-webauthn.handler.webauthn/version [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok {:version
                    {:specification
                     {:url "https://www.w3.org/TR/2019/PR-webauthn-20190117/"
                      :latestVersionUrl "https://www.w3.org/TR/webauthn/"
                      :status "proposed-recommendation"
                      :releaseDate "2019-01-17"}}}]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn/register [_ options]
  (fn [{{:keys [username displayName credentialNickname requireResidentKey]
         :or {requireResidentKey false}} :params
        :as req}]
    [::response/ok ":webauthn/register"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn.register/finish [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn.register/finish"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn.register/finish-u2f [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn.register/finish-u2f"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn/authenticate [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn/authenticate"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn.authenticate/finish [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn.authenticate/finish"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn.action/finish [_ options]
  (fn [{{:keys [action]} :route-params :as req}]
    (println action)
    [::response/ok ":webauthn.action/finish"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn.action/add-credential [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn.action/add-credential"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn.action.add-credential.finish/finish [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn.action.add-credential.finish/finish"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn.action.add-credential.finish/finish-u2f [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn.action.add-credential.finish/finish-u2f"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn.action/deregister [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn.action/deregister"]))

(defmethod ig/init-key :clj-webauthn.handler.webauthn/delete-account [_ options]
  (fn [{[_] :ataraxy/result}]
    [::response/ok ":webauthn/delete-account"]))
