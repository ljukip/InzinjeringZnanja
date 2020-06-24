
%-------------------------------determening possible diseases:----------------------------------------------

%Symptoms given by a patient will be saved in a list, and each of them will have a corresponding possible disease;
%Finding and placing corresponding disease in symptom_disease_possibility
%Patient's disease: putting all patient's symptoms in the list,finding a possible disease for all the symptoms in the list Symptoms
%------------------------------------------------------------------------------------------------------------
given_symptoms([], _D) :- !.
given_symptoms([S|G], D) :- symptom_disease_possibility(S, D, _P), given_symptoms(G, D).
possible_diseases(P, D) :- findall(X, patient(P, X), Symptoms), given_symptoms(Symptoms, D).

%-------------------------------------------example:-------------------------------------------------------
patient(ana, lacrimation).
patient(ana, foreign_body_sensation_in_eye).
%patient(ana, swollen_eye).

patient(maja, eye_redness).
patient(maja, eyelid_swelling).
patient(maja, eye_burns_or_stings).

%------------------------------------------------------------------------------------------------------------
