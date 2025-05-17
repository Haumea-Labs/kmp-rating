package com.haumealabs.rating

import platform.StoreKit.SKStoreReviewController

actual class RatingManager {

    actual fun requestInAppReview() {
        SKStoreReviewController.requestReview()
    }
}