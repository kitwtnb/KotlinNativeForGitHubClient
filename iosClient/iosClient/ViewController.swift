//
//  ViewController.swift
//  iosClient
//
//  Created by usayuki on 2018/12/06.
//  Copyright © 2018 usayuki. All rights reserved.
//

import UIKit
import ShareCode

class ViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!
    @IBOutlet weak var searchBar: UISearchBar!
    
    private var presenter: SearchRepositoryPresenter!
    private var repositories: [Item] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // TableView
        self.tableView.delegate = self
        self.tableView.dataSource = self
        self.tableView.register(UINib(nibName: "TableViewCell", bundle: nil), forCellReuseIdentifier: "tableViewCell")
        
        // ShareCode
        self.presenter = PresenterFactory().getSearchRepositoryPresenter(searchRepositoryView: self)
        self.search(for: "")
    }
    
    private func search(for query: String) {
        self.presenter.search(query: query)
    }
}

extension ViewController: SearchRepositoryView {
    func showRepositories(repositories: [Item]) {
        self.repositories = repositories
        self.tableView.reloadData()
    }

    func showError(message: String) {
        let alert = UIAlertController(title: "通信エラー", message: message, preferredStyle: .alert)
        let okAction = UIAlertAction(title: "OK", style: .default, handler: nil)
        alert.addAction(okAction)
        self.present(alert, animated: true, completion: nil)
    }
}

extension ViewController: UITableViewDelegate {
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 100
    }
}

extension ViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.repositories.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "tableViewCell", for: indexPath)
        if let cell = cell as? TableViewCell {
            let repository = repositories[indexPath.row]
            cell.configure(repository)
        }
        
        return cell
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
}
