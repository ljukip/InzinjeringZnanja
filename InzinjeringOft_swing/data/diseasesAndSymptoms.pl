%************DISEASES AND SYMPTOMS*****************


%------------diseases:
%disease_possible symptom_possibility of that symptome accuring for the given disease


%chronic glaucoma
disease_symptom_possibility(chronic_glaucoma, symptoms_of_eye, 28).
disease_symptom_possibility(chronic_glaucoma, spots_or_clouds_in_vision, 26).
disease_symptom_possibility(chronic_glaucoma, pain_in_eye, 19).
disease_symptom_possibility(chronic_glaucoma, diminished_vision, 16).
disease_symptom_possibility(chronic_glaucoma, lacrimation, 15).
disease_symptom_possibility(chronic_glaucoma, white_discharge_from_eye, 14).
disease_symptom_possibility(chronic_glaucoma, yellow_discharge_from_eye, 14).
disease_symptom_possibility(chronic_glaucoma, foreign_body_sensation_in_eye, 13).
disease_symptom_possibility(chronic_glaucoma, blindness, 12).
disease_symptom_possibility(chronic_glaucoma, itchiness_of_eye, 12).
disease_symptom_possibility(chronic_glaucoma, eye_burns_or_stings, 10).
disease_symptom_possibility(chronic_glaucoma, double_vision, 5).
disease_symptom_possibility(chronic_glaucoma, mass_on_eyelid, 4).

disease_has_symptom(chronic_glaucoma, [symptoms_of_eye, spots_or_clouds_in_vision, pain_in_eye, diminished_vision, lacrimation, white_discharge_from_eye, yellow_discharge_from_eye, blindness, itchiness_of_eye, eye_burns_or_stings, double_vision, mass_on_eyelid]).

%acuta glaucoma 
disease_symptom_possibility(acuta_glaucoma,eye_redness, 80).
disease_symptom_possibility(acuta_glaucoma, diminished_vision, 62).
disease_symptom_possibility(acuta_glaucoma, symptoms_of_eye, 28).
disease_symptom_possibility(acuta_glaucoma, spots_or_clouds_in_vision, 26).
disease_symptom_possibility(acuta_glaucoma, lacrimation, 15).
disease_symptom_possibility(acuta_glaucoma, white_discharge_from_eye, 14).
disease_symptom_possibility(acuta_glaucoma, yellow_discharge_from_eye, 14).
disease_symptom_possibility(acuta_glaucoma, foreign_body_sensation_in_eye, 13).
disease_symptom_possibility(acuta_glaucoma, blindness, 12).
disease_symptom_possibility(acuta_glaucoma, itchiness_of_eye, 12).
disease_symptom_possibility(acuta_glaucoma, eye_burns_or_stings, 10).
disease_symptom_possibility(acuta_glaucoma, pain_in_eye, 9).
disease_symptom_possibility(acuta_glaucoma, double_vision, 5).
disease_symptom_possibility(acuta_glaucoma, mass_on_eyelid, 4).

disease_has_symptom(acuta_glaucoma, [eye_redness, diminished_vision, symptoms_of_eye, spots_or_clouds_in_vision, pain_in_eye, diminished_vision, lacrimation, white_discharge_from_eye, yellow_discharge_from_eye, blindness, itchiness_of_eye, eye_burns_or_stings, double_vision, mass_on_eyelid]).

%acuta dacryocystitis (bacterial infection of lacrimal sac)
disease_symptom_possibility(acuta_dacryocystitis, lacrimation, 71).
disease_symptom_possibility(acuta_dacryocystitis, eye_redness, 66).
disease_symptom_possibility(acuta_dacryocystitis, pain_in_eye, 60).
disease_symptom_possibility(acuta_dacryocystitis, itchiness_of_eye, 40).
disease_symptom_possibility(acuta_dacryocystitis, eye_burns_or_stings, 35).
disease_symptom_possibility(acuta_dacryocystitis, symptoms_of_eye, 31).
disease_symptom_possibility(acuta_dacryocystitis, diminished_vision, 31).
disease_symptom_possibility(acuta_dacryocystitis, spots_or_clouds_in_vision, 26).

disease_has_symptom(acuta_dacryocystitis, []).

%chronic dacryocystitis (bacterial infection of lacrimal sac)
disease_symptom_possibility(chronic_dacryocystitis, lacrimation, 71).
disease_symptom_possibility(chronic_dacryocystitis, eye_redness, 66).
disease_symptom_possibility(chronic_dacryocystitis, pain_in_eye, 40).
disease_symptom_possibility(chronic_glaucoma, itchiness_of_eye, 40).
disease_symptom_possibility(chronic_glaucoma, eye_burns_or_stings, 35).
disease_symptom_possibility(chronic_glaucoma, symptoms_of_eye, 31).
disease_symptom_possibility(chronic_glaucoma, diminished_vision, 31).
disease_symptom_possibility(chronic_glaucoma, spots_or_clouds_in_vision, 26).

disease_has_symptom(acuta_dacryocystitis, [lacrimation, eye_redness, pain_in_eye,itchiness_of_eye, eye_burns_or_stings, symptoms_of_eye, diminished_vision, spots_or_clouds_in_vision]).

%vitreous hemorrhage
disease_symptom_possibility(vitreous_hemorrhage, diminished_vision, 81).
disease_symptom_possibility(vitreous_hemorrhage, spots_or_clouds_in_vision, 73).
disease_symptom_possibility(vitreous_hemorrhage, blindness, 40).
disease_symptom_possibility(vitreous_hemorrhage, symptoms_of_eye, 39).
disease_symptom_possibility(vitreous_hemorrhage, pain_in_eye, 36).
disease_symptom_possibility(vitreous_hemorrhage, bleeding_from_eye, 34).
disease_symptom_possibility(vitreous_hemorrhage, lacrimation, 26).

disease_has_symptom(vitreous_hemorrhage, [lacrimation, blindness, bleeding_from_eye, pain_in_eye, symptoms_of_eye, diminished_vision, spots_or_clouds_in_vision]).

%vitreous degeneration (glassy eye, bugs, spots...)
disease_symptom_possibility(vitreous_degeneration, spots_or_clouds_in_vision, 91).
disease_symptom_possibility(vitreous_degeneration, diminished_vision, 60).
disease_symptom_possibility(vitreous_degeneration, symptoms_of_eye, 36).
disease_symptom_possibility(vitreous_degeneration, lacrimation, 24).
disease_symptom_possibility(vitreous_degeneration, eye_redness, 11).
disease_symptom_possibility(vitreous_degeneration, blindness, 12).
disease_symptom_possibility(vitreous_degeneration, foreign_body_sensation_in_eye, 11).
disease_symptom_possibility(vitreous_degeneration, bleeding_from_eye, 6).
disease_symptom_possibility(vitreous_degeneration, double_vision, 6).
disease_symptom_possibility(vitreous_degeneration, eye_burns_or_stings, 4).
disease_symptom_possibility(vitreous_degeneration, itchiness_of_eye, 4).

disease_has_symptom(vitreous_degeneration, [lacrimation, itchiness_of_eye, eye_burns_or_stings, double_vision, foreign_body_sensation_in_eye, blindness, bleeding_from_eye, symptoms_of_eye, diminished_vision, spots_or_clouds_in_vision]).

% myopia (short sighted)
disease_symptom_possibility(myopia, diminished_vision, 81).
disease_symptom_possibility(myopia, spots_of_clouds_in_vision, 46).
disease_symptom_possibility(myopia, eye_moves_abnormally, 41).
disease_symptom_possibility(myopia, pain_in_eye, 27).
disease_symptom_possibility(myopia, symptoms_of_eye, 23).
disease_symptom_possibility(myopia, eye_redness, 15).
disease_symptom_possibility(myopia, foreign_body_sensation_in_eye, 9).
disease_symptom_possibility(myopia, itchiness_of_eye, 9).
disease_symptom_possibility(myopia, lacrimation, 9).
disease_symptom_possibility(myopia, blindness, 5).
disease_symptom_possibility(myopia, eye_deviation, 3).
disease_symptom_possibility(myopia, abnormal_movement_of_eyelid, 3).

disease_has_symptom(myopia, [diminished_vision, spots_of_clouds_in_vision, eye_moves_abnormally, pain_in_eye, eye_redness, foreign_body_sensation_in_eye, itchiness_of_eye, lacrimation, blindness, eye_deviation, abnormal_movement_of_eyelid ]).

% conjunctivitis
disease_symptom_possibility(conjunctivitis, white_discharge_from_eye, 86).
disease_symptom_possibility(conjunctivitis, lacrimation, 70).
disease_symptom_possibility(conjunctivitis, pain_in_eye, 69).
disease_symptom_possibility(conjunctivitis, eye_redness, 61).
disease_symptom_possibility(conjunctivitis, cough, 47).
disease_symptom_possibility(conjunctivitis, nasal_congestion, 46).
disease_symptom_possibility(conjunctivitis, fever, 44).
disease_symptom_possibility(conjunctivitis, itchiness_of_eye, 43).
disease_symptom_possibility(conjunctivitis, swollen_eye, 41).
disease_symptom_possibility(conjunctivitis, symptoms_of_eye, 27).
disease_symptom_possibility(conjunctivitis, sore_throat, 27).
disease_symptom_possibility(conjunctivitis, coryza, 21).

disease_has_symptom(conjunctivitis, [white_discharge_from_eye, lacrimation, pain_in_eye, eye_redness, cough, nasal_congestion, fever, itchiness_of_eye, swollen_eye, symptoms_of_eye, sore_throat, coryza]).

%conjunctivitis due to allergy
disease_symptom_possibility(conjunctivitis_allergy, itchiness_of_eye, 81).
disease_symptom_possibility(conjunctivitis_allergy, lacrimation, 74).
disease_symptom_possibility(conjunctivitis_allergy, eye_redness, 71).
disease_symptom_possibility(conjunctivitis_allergy, pain_in_eye, 66).
disease_symptom_possibility(conjunctivitis_allergy, nasal_congestion, 45).
disease_symptom_possibility(conjunctivitis_allergy, swollen_eye, 42).
disease_symptom_possibility(conjunctivitis_allergy, eye_burns_or_stings, 37).
disease_symptom_possibility(conjunctivitis_allergy, symptoms_of_eye, 34).
disease_symptom_possibility(conjunctivitis_allergy, diminished_vision, 32).
disease_symptom_possibility(conjunctivitis_allergy, allergic_reaction, 28).
disease_symptom_possibility(conjunctivitis_allergy, cough, 26).
disease_symptom_possibility(conjunctivitis_allergy, sneezing, 14).

disease_has_symptom(conjunctivitis_allergy, [itchiness_of_eye, lacrimation, eye_redness, pain_in_eye, nasal_congestion, swollen_eye, eye_burns_or_stings, symptoms_of_eye, diminished_vision, allergic_reaction, cough, sneezing ]).

%conjunctivitis due to bacteria
disease_symptom_possibility(conjunctivitis_bacteria, eye_redness, 81).
disease_symptom_possibility(conjunctivitis_bacteria, pain_in_eye, 62).
disease_symptom_possibility(conjunctivitis_bacteria, fever, 59).
disease_symptom_possibility(conjunctivitis_bacteria, white_discharge_from_eye, 49). %zuti ili zeleni, alergijski beli
disease_symptom_possibility(conjunctivitis_bacteria, nasal_congestion, 49).
disease_symptom_possibility(conjunctivitis_bacteria, itchiness_of_eye, 49).
disease_symptom_possibility(conjunctivitis_bacteria, ear_pain, 29).
disease_symptom_possibility(conjunctivitis_bacteria, sore_throat, 29).
disease_symptom_possibility(conjunctivitis_bacteria, coryza, 21).
disease_symptom_possibility(conjunctivitis_bacteria, symptoms_of_eye, 21).
disease_symptom_possibility(conjunctivitis_bacteria, abnormal_appearing_skin, 21).

disease_has_symptom(conjunctivitis_bacteria, [eye_redness, pain_in_eye, fever, white_discharge_from_eye, nasal_congestion, itchiness_of_eye,
ear_pain, sore_throat, coryza, symptoms_of_eye, abnormal_appearing_skin ]).

%conjunctivitis due to virus
disease_symptom_possibility(conjunctivitis_virus, eye_redness, 91).
disease_symptom_possibility(conjunctivitis_virus, itchiness_of_eye, 54).
disease_symptom_possibility(conjunctivitis_virus, fever, 50).
disease_symptom_possibility(conjunctivitis_virus, swollen_eye, 49).
disease_symptom_possibility(conjunctivitis_virus, nasal_congestion, 42).
disease_symptom_possibility(conjunctivitis_virus, white_discharge_from_eye, 40).
disease_symptom_possibility(conjunctivitis_virus, cough, 38).
disease_symptom_possibility(conjunctivitis_virus, lacrimation, 29).
disease_symptom_possibility(conjunctivitis_virus, coryza, 29).
disease_symptom_possibility(conjunctivitis_virus, eye_burns_or_stings, 19).
disease_symptom_possibility(conjunctivitis_virus, diminished_vision, 19).

disease_has_symptom(conjunctivitis_virus, [diminished_vision,eye_burns_or_stings,coryza,lacrimation, cough, white_discharge_from_eye, nasal_congestion, swollen_eye, fever, itchiness_of_eye, eye_redness]).

% astigmatism
disease_symptom_possibility(astigmatism, diminished_vision, 70.0).
disease_symptom_possibility(astigmatism, symptoms_of_eye, 29.0).
disease_symptom_possibility(astigmatism, eye_deviation, 26.0).
disease_symptom_possibility(astigmatism, cross_eyed, 11).
disease_symptom_possibility(astigmatism, eye_moves_abnormally, 9.0).
disease_symptom_possibility(astigmatism, double_vision, 6.0).
disease_symptom_possibility(astigmatism, lacrimation, 6.0).
disease_symptom_possibility(astigmatism, spots_of_clouds_in_vision,6.0).
disease_symptom_possibility(astigmatism, eye_redness, 1).
disease_symptom_possibility(astigmatism, itchiness_of_eye, 1).
disease_symptom_possibility(astigmatism, pain_in_eye, 1).
disease_symptom_possibility(astigmatism, foreign_body_sensation_in_eye, 1).

disease_has_symptom(astigmatism, [foreign_body_sensation_in_eye, pain_in_eye, itchiness_of_eye, eye_redness, spots_of_clouds_in_vision,lacrimation, double_vision,eye_moves_abnormally, cross_eyed, eye_deviation, symptoms_of_eye, diminished_vision]).

%cataract 
disease_symptom_possibility(cataract, diminished_vision, 70).
disease_symptom_possibility(cataract, cloudy_eye, 60).
disease_symptom_possibility(cataract, symptoms_of_eye, 26).
disease_symptom_possibility(cataract, blindness, 9).
disease_symptom_possibility(cataract, double_vision, 8).
disease_symptom_possibility(cataract, lacrimation, 6).
disease_symptom_possibility(cataract, abnormal_movement_of_eyelid, 4).
disease_symptom_possibility(cataract, spots_or_clouds_in_vision, 3).
disease_symptom_possibility(cataract, pain_in_eye, 1).
disease_symptom_possibility(cataract, itchiness_of_eye, 1).
disease_symptom_possibility(cataract, foreign_body_sensation_in_eye, 1).
disease_symptom_possibility(cataract, eye_burns_or_stings, 1).

disease_has_symptom(cataract, [diminished_vision, cloudy_eye, symptoms_of_eye, blindness, double_vision, lacrimation, abnormal_movement_of_eyelid, spots_or_clouds_in_vision, pain_in_eye, itchiness_of_eye, foreign_body_sensation_in_eye, eye_burns_or_stings]).

%conjunctivitis virus
disease_symptom_possibility(conjunctivitis_virus, eye_redness, 91).
disease_symptom_possibility(conjunctivitis_virus, itchiness_of_eye, 54).
disease_symptom_possibility(conjunctivitis_virus, swollen_eye, 49).
disease_symptom_possibility(conjunctivitis_virus, lacrimation, 29).
disease_symptom_possibility(conjunctivitis_virus, eye_burns_or_stings, 19).

disease_has_symptom(conjunctivitis_virus, [eye_redness, itchiness_of_eye, swollen_eye, lacrimation, eye_burns_or_stings]).

%------------symptoms:
%symptom_possible disease_possibility of that disease being cause of the given symptom


%blindness
symptom_disease_possibility(blindness, cataract, 13).
symptom_disease_possibility(blindness, chronic_glaucoma, 9).
symptom_disease_possibility(blindness, acuta_glaucoma, 6).
symptom_disease_possibility(blindness, macular_degeneration, 6).
symptom_disease_possibility(blindness, retinal_detachment, 5).

%eye redness
symptom_disease_possibility(eye_redness, conjunctivitis, 40).
symptom_disease_possibility(eye_redness, conjunctivitis_allergy, 11).
symptom_disease_possibility(eye_redness, conjunctivitis_virus, 9).
symptom_disease_possibility(eye_redness, subconjunctival_hemorrhage, 4).
symptom_disease_possibility(eye_redness, corneal_abrasion, 4).
symptom_disease_possibility(eye_redness, dry_eye, 6).

%itchiness of eye
symptom_disease_possibility(itchiness_of_eye, conjunctivitis, 20).
symptom_disease_possibility(itchiness_of_eye, conjunctivitis_due_to_allergy, 14).
symptom_disease_possibility(itchiness_of_eye, dry_eye_of_unknown_cause, 7).
symptom_disease_possibility(itchiness_of_eye, cataract, 7).
symptom_disease_possibility(itchiness_of_eye, dry_eye, 6).
symptom_disease_possibility(itchiness_of_eye, conjunctivitis_due_to_virus, 5).
symptom_disease_possibility(itchiness_of_eye, blepharitis, 4).

%diminished vision
symptom_disease_possibility(diminished_vision, cataract, 25).
symptom_disease_possibility(diminished_vision, macular_degeneration, 10).
symptom_disease_possibility(diminished_vision, chronic_glaucoma, 7).
symptom_disease_possibility(diminished_vision, diabetic_retinopathy, 5).
symptom_disease_possibility(diminished_vision, myopia, 4).
symptom_disease_possibility(diminished_vision, dry_eye_of_unknown_cause, 4).

%double vision
symptom_disease_possibility(double_vision, cataract, 10).
symptom_disease_possibility(double_vision, eye_alignment_disorder, 7).
symptom_disease_possibility(double_vision, myasthenia_gravis, 5).
symptom_disease_possibility(double_vision, macular_degeneration, 4).
symptom_disease_possibility(double_vision, chronic_glaucoma, 3).

%eyelid swelling
symptom_disease_possibility(eyelid_swelling, stye, 22).
symptom_disease_possibility(eyelid_swelling, conjunctivitis, 8).
symptom_disease_possibility(eyelid_swelling, blepharitis, 6).
symptom_disease_possibility(eyelid_swelling, chalazion, 5).
symptom_disease_possibility(eyelid_swelling, conjunctivitis_due_to_allergy, 3).

%swollen eye
symptom_disease_possibility(swollen_eye, conjunctivitis, 16).
symptom_disease_possibility(swollen_eye, stye, 9).
symptom_disease_possibility(swollen_eye, dry_eye, 6).
symptom_disease_possibility(swollen_eye, conjunctivitis_due_to_allergy, 4).
symptom_disease_possibility(swollen_eye, conjunctivitis_due_to_virus, 4).

%abnormal eyelid movement
symptom_disease_possibility(abnormal_movement_of_eyelid, cataract, 7).
symptom_disease_possibility(abnormal_movement_of_eyelid, blepharospasm, 5).
symptom_disease_possibility(abnormal_movement_of_eyelid, hyperopia, 4).
symptom_disease_possibility(abnormal_movement_of_eyelid, myasthenia_gravis, 3).
symptom_disease_possibility(abnormal_movement_of_eyelid, diabetic_retinopathy, 3).
symptom_disease_possibility(abnormal_movement_of_eyelid, dry_eye_of_unknown_cause, 3).

%abnormal eye movement
symptom_disease_possibility(eye_moves_abnormally, myopia, 8).
symptom_disease_possibility(eye_moves_abnormally, eye_alignment_disorder, 8).
symptom_disease_possibility(eye_moves_abnormally, astigmatism, 6).
symptom_disease_possibility(eye_moves_abnormally, chronic_glaucoma, 2).

%eye deviation
symptom_disease_possibility(eye_deviation, eye_alignment_disorder, 49).
symptom_disease_possibility(eye_deviation, amblyopia, 19).
symptom_disease_possibility(eye_deviation, hyperopia, 12).
symptom_disease_possibility(eye_deviation, astigmatism, 7).
symptom_disease_possibility(eye_deviation, myopia, 5).
symptom_disease_possibility(eye_deviation, macular_degeneration, 2).
symptom_disease_possibility(eye_deviation, chronic_glaucoma, 2).

%cross eyed
symptom_disease_possibility(cross_eyed, eye_alignment_disorder, 73).
symptom_disease_possibility(cross_eyed, astigmatism, 9).
symptom_disease_possibility(cross_eyed, amblyopia, 9).
symptom_disease_possibility(cross_eyed, hyperopia, 5).
symptom_disease_possibility(cross_eyed, myopia, 5).

%eye pain
symptom_disease_possibility(pain_in_eye, conjunctivitis, 15).
symptom_disease_possibility(pain_in_eye, corneal_abrasion, 12).
symptom_disease_possibility(pain_in_eye, foreign_body_in_the_eye, 4).
symptom_disease_possibility(pain_in_eye, subconjunctival_hemorrhage, 4).
symptom_disease_possibility(pain_in_eye, cornea_infection, 4).
symptom_disease_possibility(pain_in_eye, conjunctivitis_due_to_allergy, 4).
symptom_disease_possibility(pain_in_eye, stye, 3).
symptom_disease_possibility(pain_in_eye, cataract, 3).

%eye burns or stings
symptom_disease_possibility(eye_burns_or_stings, conjunctivitis, 16).
symptom_disease_possibility(eye_burns_or_stings, conjunctivitis_due_to_allergy, 11).
symptom_disease_possibility(eye_burns_or_stings, dry_eye_of_unknown_cause, 11).
symptom_disease_possibility(eye_burns_or_stings, cataract, 10).
symptom_disease_possibility(eye_burns_or_stings, chronic_glaucoma, 7).
symptom_disease_possibility(eye_burns_or_stings, dry_eye, 6).
symptom_disease_possibility(eye_burns_or_stings, corneal_abrasion, 4).
symptom_disease_possibility(eye_burns_or_stings, cornea_infection, 4).
symptom_disease_possibility(eye_burns_or_stings, foreign_body_in_the_eye, 4).

%foreign body sensation
symptom_disease_possibility(foreign_body_sensation_in_eye, cataract, 10).
symptom_disease_possibility(foreign_body_sensation_in_eye, dry_eye_of_unknown_cause, 10).
symptom_disease_possibility(foreign_body_sensation_in_eye, chronic_glaucoma, 9).
symptom_disease_possibility(foreign_body_sensation_in_eye, conjunctivitis, 8).
symptom_disease_possibility(foreign_body_sensation_in_eye, foreign_body_in_the_eye, 8).
symptom_disease_possibility(foreign_body_sensation_in_eye, corneal_abrasion, 8).
symptom_disease_possibility(foreign_body_sensation_in_eye, cornea_infection, 7).
symptom_disease_possibility(foreign_body_sensation_in_eye, macular_degeneration, 4).

%lacrimation
symptom_disease_possibility(lacrimation, conjunctivitis, 13).
symptom_disease_possibility(lacrimation, cataract, 6).
symptom_disease_possibility(lacrimation, conjunctivitis_due_to_allergy, 8).
symptom_disease_possibility(lacrimation, dry_eye, 8).
symptom_disease_possibility(lacrimation, dry_eye_of_unknown_cause, 7).

%spots or clouds in vision
symptom_disease_possibility(spots_or_clouds_in_vision, cataract, 23).
symptom_disease_possibility(spots_or_clouds_in_vision, vitreous_degeneration, 15).
symptom_disease_possibility(spots_or_clouds_in_vision, macular_degeneration, 13).
symptom_disease_possibility(spots_or_clouds_in_vision, chronic_glaucoma, 9).
symptom_disease_possibility(spots_or_clouds_in_vision, floaters, 8).
symptom_disease_possibility(spots_or_clouds_in_vision, diabetic_retinopathy, 6).
symptom_disease_possibility(spots_or_clouds_in_vision, retinal_detachment, 5).
symptom_disease_possibility(spots_or_clouds_in_vision, myopia, 5).

%eyelid lesion
symptom_disease_possibility(eyelid_lesion_or_rash, conjunctivitis, 7).
symptom_disease_possibility(eyelid_lesion_or_rash, stye, 7).
symptom_disease_possibility(eyelid_lesion_or_rash, chalazion, 5).
symptom_disease_possibility(eyelid_lesion_or_rash, blepharitis, 5).
symptom_disease_possibility(eyelid_lesion_or_rash, cataract, 3).
symptom_disease_possibility(eyelid_lesion_or_rash, bell_palsy, 3).

%eyelid rash
symptom_disease_possibility(eyelid_lesion_or_rash, conjunctivitis, 7).
symptom_disease_possibility(eyelid_lesion_or_rash, stye, 7).
symptom_disease_possibility(eyelid_lesion_or_rash, chalazion, 5).
symptom_disease_possibility(eyelid_lesion_or_rash, blepharitis, 5).
symptom_disease_possibility(eyelid_lesion_or_rash, cataract, 3).
symptom_disease_possibility(eyelid_lesion_or_rash, bell_palsy, 3).

%eye symptoms
symptom_disease_possibility(symptoms_of_eye, dry_eye_of_unknown_cause, 12).
symptom_disease_possibility(symptoms_of_eye, cataract, 10).
symptom_disease_possibility(symptoms_of_eye, conjunctivitis, 7).
symptom_disease_possibility(symptoms_of_eye, chronic_glaucoma, 6).
symptom_disease_possibility(symptoms_of_eye, macular_degeneration, 3).
symptom_disease_possibility(symptoms_of_eye, corneal_abrasion, 3).
symptom_disease_possibility(symptoms_of_eye, subconjunctival_hemorrhage, 3).

%----------------------------------------------------------------------------------- 


symptoms_value(Symptom, Disease, Val) :- disease_symptom_possibility(Disease, Symptom, X), Val = X, !.
symptoms_value(_, _, 0).

function2(Disease, [H|T], RetVal) :-  symptoms_value(H, Disease, Num), function2(Disease, T, RetVal1), RetVal is (Num + RetVal1) .

function2(Disease, [], 0).

count(Array1, Array2, Num) :- length(Array1, D), D < 1, Num = 0.
count([H|T], Array, Num) :- member(H, Array), count(T, Array, Num1), Num = 1 + Num1.
count([H|T], Array, Num) :- not member(H, Array), count(T, Array, Num1), Num = 0 + Num1.
function(Symptom, Disease, No) :- disease_has_symptom(Disease, Array), count(Symptom, Array, Num), No is Num.

avg_symptom_disease(Disease, [H|T], X) :- function([H|T], Disease, NumS), NumS > 0,  function2(Disease, [H|T], RetVal), X is RetVal / NumS, !.
