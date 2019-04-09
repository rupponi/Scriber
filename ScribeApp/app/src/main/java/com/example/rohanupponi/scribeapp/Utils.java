package com.example.rohanupponi.scribeapp;

enum Gender {
    NONE, MALE, FEMALE
}

enum State {
    NONE, AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MA,
    MI, MN, MS, MO, MT, NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK, OR, PA, RI, SC, SD, TN, TX, UT,
    VT, VA, WA, WV, WI, WY
}

enum Ethnicity {
    NONE, NORTH_AMERICAN_DESCENT, ASIAN_DESCENT, AFRICAN_DESCENT,
    PACIFIC_ISLAND_DESCENT, CAUCASIAN_DESCENT
}

enum MaritalStatus {
    NONE, SINGLE, MARRIED, WIDOWED, SEPARATED, DIVORCED
}

enum BloodType {
    NONE, A_POS, A_NEG, B_POS, B_NEG, AB_POS, AB_NEG, O_POS, O_NEG
}

public class Utils {

    public static State getState(int stateIndex) {
        return State.values()[stateIndex + 1];
    }

    public static Ethnicity getEthnicity(int ethnicityIndex) {
        return Ethnicity.values()[ethnicityIndex];
    }

    public static Gender getGender(int genderIndex) {
        return Gender.values()[genderIndex];
    }

    public static MaritalStatus getMaritalStatus(int maritalStatusIndex) {
        return MaritalStatus.values()[maritalStatusIndex];
    }

    public BloodType getBloodType(int bloodTypeIndex) {
        return BloodType.values()[bloodTypeIndex];
    }
}