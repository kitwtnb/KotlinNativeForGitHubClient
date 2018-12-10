//
//  UIImageView+URLSession.swift
//  iosClient
//
//  Created by usayuki on 2018/12/10.
//  Copyright © 2018 usayuki. All rights reserved.
//

import UIKit

extension UIImageView {
    func setImage(from urlString: String) {
        guard let url = URL(string: urlString) else { return }
        URLSession.shared.dataTask(with: url) { data, response, error in
            guard let data = data, let _ = response, error == nil else { return }
            DispatchQueue.main.async {
                self.image = UIImage(data: data)
            }
        }.resume()
    }
}
